package StackOverflowDesignIncomplete;

public class Comment {
    private final int id;
    private final String text;
    private final User author;

    public Comment(int id, String text, User author) {
        this.id = id; this.text = text; this.author = author;
    }
}
