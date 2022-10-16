package org.example;


public class Question {

    private Integer id;
    private String name;
    private Integer difficultyRank;
    private Integer topicId;

    public Question() {
    }

    public Question(String name, Integer difficultyRank, Integer topicId) {
        this.name = name;
        this.difficultyRank = difficultyRank;
        this.topicId = topicId;
    }

    public Question(Integer id, String name, Integer difficultyRank, Integer topicId) {
        this.id = id;
        this.name = name;
        this.difficultyRank = difficultyRank;
        this.topicId = topicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDifficultyRank() {
        return difficultyRank;
    }

    public void setDifficultyRank(Integer difficultyRank) {
        this.difficultyRank = difficultyRank;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }
}

