package org.example;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        QuestionDao questionDao = new QuestionDao();

        //create
        /* Question question = new Question("Who is POTUS?", 3, 1);
            questionDao.create(question); */


        //find by id
        /* Integer questionId =7;
        Question question = questionDao.findById(questionId);
        System.out.println(question.getName()); */


        //find all
        /* List<Question> questions = questionDao.findAll();
        for(Question question : questions){
            System.out.println(question.getName());
        } */

        //find all by topic
        /* Integer topicId = 2;
        List<Question> questions = questionDao.findAllByTopicId(topicId);
        for(Question question : questions){
            System.out.println(question.getName());
        } */


        //update
        /* Integer questionId = 7;
        Question question = new Question(questionId, "Who is PRESIDENT OF U.S.A?", 3, 1);
        questionDao.update(question);
        System.out.println(questionDao.findById(questionId).getName()); */


        //delete
       /* Integer questionId = 7;
        questionDao.delete(questionId);
        System.out.println(questionDao.findById(questionId).getName()); // NullPointerException - Question with id 7 is deleted.
        */


    }
}
