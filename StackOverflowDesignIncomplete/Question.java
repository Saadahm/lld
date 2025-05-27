package StackOverflowDesignIncomplete;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final int id;
    private final List<Tag> tags;
    private final String text;
    private final User author;
    private final List<Answer> answers = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();

    public Question(int id, List<Tag> tags, String text, User author) {
        this.id = id; this.tags = tags; this.text = text; this.author = author;
    }
    public int getId() { return id; }
    public String getText() { return text; }
    public List<Tag> getTags() { return tags; }
    public void addAnswer(Answer a) { answers.add(a); }
    public void addComment(Comment c) { comments.add(c); }
}
