package StackOverflowDesignIncomplete;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StackOverflowSystem {
    private List<User> users = new ArrayList<>();
    private static StackOverflowSystem instance;
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private final AtomicInteger questionIdGen = new AtomicInteger(1);
    private final AtomicInteger answerIdGen = new AtomicInteger(1);
    private final AtomicInteger commentIdGen = new AtomicInteger(1);

    private StackOverflowSystem() {

    }

    public static synchronized StackOverflowSystem getInstance() {
        if (instance == null) instance = new StackOverflowSystem();
        return instance;
    }

    void initUsers(User user) {
        users.add(user);
    }

    public int nextQuestionId() {
        return questionIdGen.getAndIncrement();
    }

    public int nextAnswerId() {
        return answerIdGen.getAndIncrement();
    }

    public int nextCommentId() {
        return commentIdGen.getAndIncrement();
    }

    void postQuestion(Question question, User user) {
        questions.add(question);
        user.addQuestion(question);
    }

    void answerQuestion(Answer answer, User user) {
        answers.add(answer);
        answer.getQuestion().addAnswer(answer);
        user.addAnswer(answer);
    }

    public void commentOnQuestion(int questionId, Comment c, User u) {
        Question q = findQuestionById(questionId);
        comments.add(c);
        q.addComment(c);
        u.addComment(c);
    }
    public void commentOnAnswer(int answerId, Comment c, User u) {
        Answer a = answers.stream().filter(x -> x.getId() == answerId)
                .findFirst().orElseThrow(() -> new NoSuchElementException("Answer not found"));
        comments.add(c);
        a.addComment(c);
        u.addComment(c);
    }

    public User findUserById(int id) {
        return users.stream().filter(u -> u.getId() == id)
                .findFirst().orElseThrow(() -> new NoSuchElementException("User not found"));
    }
    public Question findQuestionById(int id) {
        return questions.stream().filter(q -> q.getId() == id)
                .findFirst().orElseThrow(() -> new NoSuchElementException("Question not found"));
    }

    public List<Question> questionsBasedOnTags(List<String> inputTags) {
        Set<String> tagset = new HashSet<>(inputTags);
        var out = new ArrayList<Question>();
        for (Question q : questions)
            if (q.getTags().stream().anyMatch(t -> tagset.contains(t.getName())))
                out.add(q);
        return out;
    }
    public List<Question>getAllQuestions(){
        return questions;
    }
    public List<Answer>getAllAnswers(){
        return answers;
    }
}