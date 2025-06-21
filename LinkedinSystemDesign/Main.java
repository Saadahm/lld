package LinkedinSystemDesign;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedInService linkedInService = LinkedInService.getInstance();
        User user1 = new User("John Doe", "john@example.com", "password");
        User user2 = new User("Jane Smith", "jane@example.com", "password");
        linkedInService.addUser(user1);
        linkedInService.addUser(user2);

        // Set user profile
        Profile profile = new Profile();
        profile.setHeadline("Software Engineer");
        profile.setSummary("Passionate about coding and problem-solving.");
        user1.setProfile(profile);

        Profile profile2 = new Profile();
        profile2.setHeadline("Data Analyst");
        profile2.setSummary("Passionate about coding and problem-solving.");
        user2.setProfile(profile2);

        linkedInService.sendMessage(user1, user2, "Hi Jane, hope you're doing well!");
        JobPosting jobPosting1 = linkedInService.postJobListing("Software Developer", "Discord", "AI Engineer", "San Francisco");
        JobPosting jobPosting2 = linkedInService.postJobListing("Software Developer", "Airbnb", "Full Stack Developer", "Seattle");

        System.out.println("Job Posting Results:");
        for (JobPosting posting : linkedInService.getJobPostings("Stack")) {
            System.out.println("Title: " + posting.getTitle());
            System.out.println("Description: " + posting.getDescription());
            System.out.println();
        }
        linkedInService.sendConnectionRequest(user1, user2);

        // Accept connection request
        linkedInService.acceptConnectionRequest(user2, user1);

        List<Notification> notifications = linkedInService.getNotifications(user2.getId());
        System.out.println("Notifications:");
        for (Notification notification : notifications) {
            System.out.println("Type: " + notification.getType());
            System.out.println("Content: " + notification.getContent());
            System.out.println();
        }

    }
}
