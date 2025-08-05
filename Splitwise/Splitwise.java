package Splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {
    private Map<String, User> users;
    private Map<String, Expense> expenses;
    private Map<String, Group> groups;
    private static Splitwise instance;

    private Splitwise() {
        users = new HashMap<>();
        groups = new HashMap<>();
        expenses = new HashMap<>();
    }

    public static Splitwise getInstance() {
        if (instance == null) {
            instance = new Splitwise();
        }
        return instance;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        System.out.println("User created: " + name + " (ID: " + user.getId() + ")");
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void addUserToGroup(String userId, String groupId) {
        User user = getUser(userId);
        Group group = getGroup(groupId);

        if (user != null && group != null) {
            group.addMember(user);
        }
    }

    public Group createGroup(String name) {
        Group group = new Group(name);
        groups.put(group.getGroupId(), group);
        System.out.println("Group created: " + name + " (ID: " + group.getGroupId() + ")");
        return group;
    }

    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }

    public void addExpenseToGroup(String groupId, String description, double amount,
                                  String paidByUserId, List<String> involvedUsers,
                                  SplitType splitType, List<Double> values) {
        Group group = getGroup(groupId);
        if (group == null) {
            System.out.println("Group not found!");
            return;
        }
        group.addExpense(description, amount, paidByUserId, involvedUsers, values, splitType);
    }

    public void addExpenseToGroup(String groupId, String description, double amount,
                                  String paidByUserId, List<String> involvedUsers,
                                  SplitType splitType) {
        addExpenseToGroup(groupId, description, amount, paidByUserId, involvedUsers, splitType, new ArrayList<>());
    }

    public void showGroupBalances(String groupId) {
        Group group = getGroup(groupId);
        if (group == null) return;

        group.showGroupBalances();
    }

    public void simplifyGroupDebts(String groupId) {
        Group group = getGroup(groupId);
        if (group == null) return;

        // Use group's balance data for debt simplification
        group.simplifyDebt();
    }
}
