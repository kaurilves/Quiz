package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionDaoImpl extends QuestionDao<Question> {

    private static final String INSERT = "INSERT into questions(NAME,DIFFICULTY_RANK,TOPICS_ID) VALUES(?,?,?)";
    private static final String GET_ONE = "SELECT ID,NAME,DIFFICULTY_RANK,TOPICS_ID FROM questions WHERE ID=?";
    private static final String UPDATE = "UPDATE questions SET NAME =?, DIFFICULTY_RANK=?, TOPICS_ID WHERE ID=?";
    private static final String DELETE = "DELETE FROM questions WHERE customer_id=?";
    private static final String GET_LIST_BY_TOPIC = "SELECT * FROM questions WHERE TOPICS_ID=?";

    public QuestionDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Question question) {

    }

    @Override
    public void create(Question question) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Question> findAllByTopicId(Integer topicId) {
        List<Question> questions = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_LIST_BY_TOPIC);
            ps.setInt(1, topicId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("ID"));
                question.setName(rs.getString("NAME"));
                question.setDifficultyRank(rs.getInt("DIFFICULTY_RANK"));
                question.setTopicId(rs.getInt("TOPICS_ID"));
                questions.add(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
}



