package StackOverflowDesignIncomplete;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private final List<Question> userQuestions = new ArrayList<>();
    private final List<Answer> userAnswers = new ArrayList<>();
    private final List<Comment> userComments = new ArrayList<>();
    private int reputation = 0;

    public User(int id, String name) {
        this.id = id; this.name = name;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public void addQuestion(Question q) {
        userQuestions.add(q); reputation += 5;
    }
    public void addAnswer(Answer a) {
        userAnswers.add(a); reputation += 10;
    }
    public void addComment(Comment c) {
        userComments.add(c); reputation += 1;
    }
    public List<Question> getUserQuestions() { return userQuestions; }
}

