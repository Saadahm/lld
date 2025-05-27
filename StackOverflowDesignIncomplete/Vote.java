package StackOverflowDesignIncomplete;

public class Vote {
    public enum VoteType { UPVOTE, DOWNVOTE }
    private final int id;
    private final User voter;
    private final VoteType type;

    public Vote(int id, User voter, VoteType type) {
        this.id = id; this.voter = voter; this.type = type;
    }
}
