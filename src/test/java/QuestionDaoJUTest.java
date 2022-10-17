import org.example.Question;
import org.example.QuestionDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class QuestionDaoJUTest {

    QuestionDao questionDao = new QuestionDao();
    Connection connection = questionDao.connection;
    Assertions Assert;

    @Test
    public void testAddClient(){
        Question insertedQuestion = new Question("Test question", 1, 2);

        try{
            connection.setAutoCommit(false);
            questionDao.create(insertedQuestion);

            Assert.assertNotNull(insertedQuestion);
            Assert.assertTrue(8 < insertedQuestion.getId()); // test correct id
            Assert.assertEquals(7, questionDao.findAll().size()); // test all row in the table

            //test the new inserted row
            Question question = questionDao.findById(insertedQuestion.getId());
            Assert.assertEquals(insertedQuestion.getName(), question.getName());
            Assert.assertEquals(insertedQuestion.getDifficultyRank(), question.getDifficultyRank());
            Assert.assertEquals(insertedQuestion.getTopicId(), question.getTopicId());


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return;
    }
}
