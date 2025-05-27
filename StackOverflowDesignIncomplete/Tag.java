package StackOverflowDesignIncomplete;

public class Tag {
    private int id;
    private String name;

    public Tag(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName()
    {
        return this.name;
    }
}
