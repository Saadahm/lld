package StackOverflowDesignIncomplete;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private final int id;
    private final String text;
    private final User author;
    private final Question question;
    private final List<Comment> comments = new ArrayList<>();

    public Answer(int id, String text, User author, Question question) {
        this.id = id; this.text = text; this.author = author; this.question = question;
    }
    public int getId() { return id; }
    public Question getQuestion() { return question; }
    public void addComment(Comment c) { comments.add(c); }

    public String getText() {
        return text;
    }
}
