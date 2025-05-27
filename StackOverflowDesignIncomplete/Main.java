package StackOverflowDesignIncomplete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user1=new User(1, "FirstUser");
        User user2= new User(2, "SecondUser");
        StackOverflowSystem system= StackOverflowSystem.getInstance();
        system.initUsers(user1);
        system.initUsers(user2);

        Tag tag1= new Tag("history",1);
        Tag tag2= new Tag("science", 2);
        String choice;
        Scanner scanner=new Scanner(System.in);

        do {
            System.out.println("\nMenu: 1=Post Question, 2=Answer Question, 3=Comment on Answer, 4=Required List, 5=Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine().trim();
            //demo for user 1
            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter your user id: ");
                        int uid = Integer.parseInt(scanner.nextLine());
                        User u = system.findUserById(uid);
                        System.out.print("Enter question text: ");
                        String text = scanner.nextLine();
                        Question q = new Question(system.nextQuestionId(), List.of(tag1), text, u);
                        system.postQuestion(q, u);
                        System.out.println("Question posted.");
                    }
                    case "2" -> {
                        System.out.print("Enter your user id: ");
                        int uid = Integer.parseInt(scanner.nextLine());
                        User u = system.findUserById(uid);
                        System.out.println("Available questions:");
                        for (Question q : system.getAllQuestions()) {
                            System.out.printf("  [%d] %s%n", q.getId(), q.getText());
                        }
                        System.out.print("Enter question id to answer: ");
                        System.out.print("Enter question id to answer: ");
                        int qid = Integer.parseInt(scanner.nextLine());
                        Question q = system.findQuestionById(qid);
                        System.out.print("Enter answer text: ");
                        String ans = scanner.nextLine();
                        Answer a = new Answer(system.nextAnswerId(), ans, u, q);
                        system.answerQuestion(a, u);
                        System.out.println("Answer posted.");
                    }
                    case "3" -> {
                        System.out.print("Comment on (q)uestion or (a)nswer? ");
                        String which = scanner.nextLine().trim();
                        System.out.print("Enter your user id: ");
                        int uid = Integer.parseInt(scanner.nextLine());
                        User u = system.findUserById(uid);
                        // show target list
                        if (which.equalsIgnoreCase("q")) {
                            System.out.println("Available questions:");
                            for (Question qq : system.getAllQuestions()) {
                                System.out.printf("  [%d] %s%n", qq.getId(), qq.getText());
                            }
                        } else {
                            System.out.println("Available answers:");
                            for (Answer aa : system.getAllAnswers()) {
                                System.out.printf("  [%d] %s -> %s%n", aa.getId(), aa.getQuestion().getText(), aa.getText());
                            }
                        }
                        System.out.print("Enter target id: ");
                        int targetId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter comment text: ");
                        String text = scanner.nextLine();

                        Comment c = new Comment(system.nextCommentId(), text, u);
                        if (which.equalsIgnoreCase("q")) system.commentOnQuestion(targetId, c, u);
                        else system.commentOnAnswer(targetId, c, u);
                        System.out.println("Comment added.");
                    }
                    case "4" -> {
                        System.out.print("How many tags to search? ");
                        int n = Integer.parseInt(scanner.nextLine());
                        List<String> tags = new ArrayList<>();
                        System.out.println("Enter tags:");
                        for (int i = 0; i < n; i++) tags.add(scanner.nextLine());
                        var results = system.questionsBasedOnTags(tags);
                        System.out.println("Results:");
                        results.forEach(r -> System.out.println(r.getId() + ": " + r.getText()));
                    }
                    case "5" -> System.out.println("Exiting. Goodbye!");
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (!choice.equals("5"));
    }
}
