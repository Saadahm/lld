package Splitwise;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Splitwise splitwise=Splitwise.getInstance();
        System.out.println("\n=========== Creating Users ====================");
        User user1= splitwise.createUser("Saad","saad@gmail.com");
        User user2= splitwise.createUser("Rohan", "rohan@gmail.com");
        User user3=splitwise.createUser("Raj", "raj@gmail.com");

        System.out.println("\n=========== Creating Group and Adding Members ====================");
        Group hostelGroup = splitwise.createGroup("Hostel Expenses");
        splitwise.addUserToGroup(user1.getId(), hostelGroup.getGroupId());
        splitwise.addUserToGroup(user2.getId(), hostelGroup.getGroupId());
        splitwise.addUserToGroup(user3.getId(), hostelGroup.getGroupId());

        List<String> groupMembers = Arrays.asList(user1.getId(), user2.getId(), user3.getId());
        splitwise.addExpenseToGroup(hostelGroup.getGroupId(), "Lunch", 800.0, user1.getId(), groupMembers, SplitType.EQUAL);

        System.out.println("\n=========== printing Group-Specific Balances ====================");
        splitwise.showGroupBalances(hostelGroup.getGroupId());

        System.out.println("\n=========== Debt Simplification ====================");
        splitwise.simplifyGroupDebts(hostelGroup.getGroupId());

        System.out.println("\n=========== printing Group-Specific Balances ====================");
        splitwise.showGroupBalances(hostelGroup.getGroupId());

    }
}
