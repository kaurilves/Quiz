package org.example;


public class Main {

    public static void main(String[] args) throws Exception {

        QuestionDao qd = new QuestionDao();
        Question question = new Question("Mis su nim on", 2, 2);
        qd.create(question);

    }
}