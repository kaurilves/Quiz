package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {

    public static Connection connection;

    private static final String INSERT = "INSERT into questions(NAME,DIFFICULTY_RANK,TOPICS_ID) VALUES(?,?,?)";
    private static final String GET_ONE = "SELECT ID,NAME,DIFFICULTY_RANK,TOPICS_ID FROM questions WHERE ID=?";
    private static final String UPDATE = "UPDATE questions SET NAME =?, DIFFICULTY_RANK=?, TOPICS_ID=? WHERE ID=?";
    private static final String DELETE = "DELETE FROM questions WHERE ID=?";
    private static final String GET_ALL = "SELECT * FROM questions";
    private static final String GET_LIST_BY_TOPIC = "SELECT * FROM questions WHERE TOPICS_ID=?";



    public  QuestionDao(){
        if(connection == null){
            String dbUrl = "jdbc:mysql://localhost:3306/quizdb";
            try {
                connection = DriverManager.getConnection (dbUrl, "root", "password");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


        public void create(Question question) {

        try{
            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setString(1, question.getName());
            ps.setInt(2, question.getDifficultyRank());
            ps.setInt(3, question.getTopicId());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Question findById (Integer id) {
        Question question = null;
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ONE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                question = new Question();
                question.setId(rs.getInt("ID"));
                question.setName(rs.getString("NAME"));
                question.setDifficultyRank(rs.getInt("DIFFICULTY_RANK"));
                question.setTopicId(rs.getInt("TOPICS_ID"));

            }
        }  catch(Exception e) {
            e.printStackTrace();
        }
        return question;
    }

    public List<Question> findAll () {
        List<Question> questions = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("ID"));
                question.setName(rs.getString("NAME"));
                question.setDifficultyRank(rs.getInt("DIFFICULTY_RANK"));
                question.setTopicId(rs.getInt("TOPICS_ID"));
                questions.add(question);
            }
        }  catch(Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    public void update(Question question) {

        try{
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, question.getName());
            ps.setInt(2, question.getDifficultyRank());
            ps.setInt(3, question.getTopicId());
            ps.setInt(4, question.getId());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try{
            PreparedStatement ps = connection.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

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



