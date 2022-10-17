package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("jdbc:mysql://localhost:3306/quizdb", "root", "password");
        try {
            Connection connection = dcm.getConnection();
            QuestionDaoImpl questionDaoImpl = new QuestionDaoImpl(connection);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}