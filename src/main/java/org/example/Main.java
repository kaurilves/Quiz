package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws Exception {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("jdbc:mysql://localhost:3306/quizdb", "root", "password");
        try {
            Connection connection = dcm.getConnection();
            QuestionDao questionDao = new QuestionDao(connection);
            //Question question = new Question("Who is President of Estonia?", 2, 3);
            //questionDao.create(question);

            Question questionUpdate = new Question(3, "who is who?", 5, 2);
            questionDao.update(questionUpdate);


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}