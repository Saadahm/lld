package Splitwise;

import java.text.DecimalFormat;
import java.util.*;

public class Group {
    private String groupId;
    private String name;
    private Map<String, Expense> groupExpenses;
    private Map<String, Map<String, Double>>groupBalances;
    private List<User>members;
    public Group(String name){
        this.groupId= UUID.randomUUID().toString();
        this.name=name;
        this.members= new ArrayList<>();
        this.groupBalances= new HashMap<>();
        this.groupExpenses= new HashMap<>();
    }

    private User getUserByuserId(String userId) {
        User user = null;

        for(User member : members) {
            if(member.getId().equals(userId)) {
                user = member;
            }
        }
        return user;
    }

    public void addMember(User user)
    {
        members.add(user);
        groupBalances.put(user.getId(), new HashMap<>());
        System.out.println(user.getName() + " added to group " + name);
    }

    public boolean removeMember(String userId) {
        if(!canLeaveGroup(userId))
        {
            System.out.println("Cant leave group");
            return false;
        }
        members.removeIf(user -> user.getId().equals(userId));

        groupBalances.remove(userId);

        for(Map.Entry<String, Map<String, Double>>m: groupBalances.entrySet())
        {
            m.getValue().remove(userId);
        }

        return true;
    }
    public boolean canLeaveGroup(String userId)
    {
        if(!isMember(userId))
            throw new RuntimeException("user is not a part of this group");
        //balances should be 0
        Map<String, Double>m=groupBalances.get(userId);
        for(Map.Entry<String, Double>entry: m.entrySet())
        {
            String otherUserId=entry.getKey();
            Double value=entry.getValue();
            if(value!=0)
                return false;
        }
        return true;
    }
    public boolean isMember(String userId)
    {
        return groupBalances.containsKey(userId);
    }
    public void notifyMembers(String message)
    {
        for(User u: members)
            u.update(message);
    }


    public void updateGroupBalance(String fromUserId, String toUserId, double amount) {
        // Initialize maps if not present
        groupBalances.putIfAbsent(fromUserId, new HashMap<>());
        groupBalances.putIfAbsent(toUserId, new HashMap<>());

        Map<String, Double> fromUserBalances = groupBalances.get(fromUserId);
        Map<String, Double> toUserBalances = groupBalances.get(toUserId);

        // Update balances
        //user b ows me (user a) amount thats why +
        fromUserBalances.put(toUserId, fromUserBalances.getOrDefault(toUserId, 0.0) + amount);
        toUserBalances.put(fromUserId, toUserBalances.getOrDefault(fromUserId, 0.0) - amount);

        // Clean up zero balances
        if (Math.abs(fromUserBalances.getOrDefault(toUserId, 0.0)) < 0.01)
            fromUserBalances.remove(toUserId);

        if (Math.abs(toUserBalances.getOrDefault(fromUserId, 0.0)) < 0.01)
            toUserBalances.remove(fromUserId);
    }

    public boolean addExpense(String description, double amount, String paidByUserId, List<String>involvedUsers,
                              List<Double>values, SplitType splitType)
    {
        if (!isMember(paidByUserId)) {
            throw new IllegalArgumentException("Payer is not a member of this group");
        }
        for (String uid : involvedUsers) {
            if (!isMember(uid)) {
                throw new IllegalArgumentException("User " + uid + " is not a member of this group");
            }
        }

        SplitStrategy splitStrategy=SplitFactory.getSplitStrategy(splitType);
        List<Split>splits=splitStrategy.calculateSplit(amount, involvedUsers, values);
        Expense expense= new Expense(description, amount, paidByUserId, splits, groupId);
        groupExpenses.put(expense.getExpenseId(),expense);

        for (Split split : splits) {
        if (!split.getUserId().equals(paidByUserId)) {
            // Person who paid gets positive balance, person who owes gets negative
            updateGroupBalance(paidByUserId, split.getUserId(), split.getAmount());
        }
    }

        System.out.println("\n=========== Sending Notifications ====================");
        String paidByName = getUserByuserId(paidByUserId).getName();
        notifyMembers("New expense added: " + description + " (Rs " + amount + ")");

        // Printing console message-------
        System.out.println("\n=========== Expense Message ====================");
        System.out.println("Expense added to " + name + ": " + description + " (Rs " + amount
                + ") paid by " + paidByName +" and involved people are : ");
        if(!values.isEmpty()) {
            for(int i=0; i<values.size(); i++) {
                System.out.println(getUserByuserId(involvedUsers.get(i)).getName() + " : " + values.get(i));
            }
        }
        else {
            for(String user : involvedUsers) {
                System.out.print(getUserByuserId(user).getName() + ", ");
            }
            System.out.println("\nWill be Paid Equally");
        }

        return true;
    }
    public void simplifyDebt()
    {
        groupBalances= DebtSimplifier.simplifyDebts(groupBalances);
        System.out.println("\nDebts have been simplified for group: " + name);
    }


    public void showGroupBalances() {
        System.out.println("\n=== Group Balances for " + name + " ===");
        DecimalFormat df = new DecimalFormat("#.##");

        for (User member : members) {
            String memberId   = member.getId();
            String memberName = member.getName();
            System.out.println(memberName + "'s balances in group:");

            Map<String, Double> userBalances =
                    groupBalances.getOrDefault(memberId, Collections.emptyMap());

            if (userBalances.isEmpty()) {
                System.out.println("  No outstanding balances");
            } else {
                for (Map.Entry<String, Double> bal : userBalances.entrySet()) {
                    String otherId = bal.getKey();
                    double amount  = bal.getValue();

                    // look up name safely
                    User other = getUserByuserId(otherId);
                    String otherName = (other != null ? other.getName() : otherId);

                    if (amount > 0) {
                        System.out.println("  " + otherName + " owes: Rs " + df.format(amount));
                    } else {
                        System.out.println("  Owes " + otherName + ": Rs " + df.format(Math.abs(amount)));
                    }
                }
            }
        }
    }


    public String getGroupId(){
        return groupId;
    }
}
