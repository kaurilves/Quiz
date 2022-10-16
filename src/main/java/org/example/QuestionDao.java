package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QuestionDao extends Dao<Question> {

    private static final String INSERT =
            "INSERT into questions(NAME,DIFFICULTY_RANK,TOPICS_ID) VALUES(?,?,?)";

    private static final String GET_ONE = "SELECT ID,NAME,DIFFICULTY_RANK,TOPICS_ID FROM questions WHERE ID=?";

    private static final String UPDATE = "UPDATE questions SET NAME=?, DIFFICULTY_RANK=?,TOPICS_ID=? WHERE ID=?";

    private static final String DELETE = "DELETE FROM questions WHERE ID=?";


    public QuestionDao(Connection connection) {
        super(connection);
    }

    @Override
    public Question create(Question dto) {

        try (PreparedStatement statement = this.connection.prepareStatement(INSERT)) {
            statement.setString(1, dto.getName());
            statement.setInt(2, dto.getDifficultyRank());
            statement.setInt(3, dto.getTopicId());
            statement.execute();
            return null;


        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Question findById(Integer id) {
        Question question = new Question();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(GET_ONE)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                question.setId(resultSet.getInt("ID"));
                question.setName(resultSet.getString("NAME"));
                question.setDifficultyRank(resultSet.getInt("DIFFICULTY_RANK"));
                question.setTopicId(resultSet.getInt("TOPICS_ID"));

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);

        }
        return question;
    }

    @Override
    public void delete(Integer id) {
        int i;
        Question question = new Question();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(DELETE)) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);

        }
    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public Question update(Question dto) {
        Question question = null;
        try {
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            statement.setString(1, dto.getName());
            statement.setInt(2, dto.getDifficultyRank());
            statement.setInt(3, dto.getTopicId());
            statement.setInt(4, dto.getId());
            statement.execute();
            this.connection.commit();
            question = this.findById(dto.getId());
        } catch (SQLException exception) {
            try {
                this.connection.rollback();
            } catch (SQLException sqlException) {
                exception.printStackTrace();
                throw new RuntimeException(sqlException);
            }
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
        return question;
    }
}



