package org.example;


import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public abstract class QuestionDao<Question> {

    protected final Connection connection;

    public abstract void create(Question question);

    public abstract Question findById(Integer id);

    public abstract void update(Question question);

    public abstract void delete(Integer id);

    public abstract List<Question> findAllByTopicId(Integer topicId);

    protected QuestionDao(Connection connection) {
        this.connection = connection;
    }
}