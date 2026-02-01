package MeetingScheduler;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MeetingSchedulerService meetingSchedulerService=MeetingSchedulerService.getInstance();
        User user1=new User("Saad");
        User user2=new User("Rohan");
        User user3=new User("Mohan");
        meetingSchedulerService.addUser(user1);
        meetingSchedulerService.addUser(user2);
        meetingSchedulerService.addUser(user3);
        Meeting meeting =new Meeting(LocalDateTime.of(2026,01,30,11,0),
                LocalDateTime.of(2026,01,30,11,30), user1);

        Meeting meeting1 =new Meeting(LocalDateTime.of(2026,01,30,12,0),
                LocalDateTime.of(2026,01,30,12,30), user1);
        meetingSchedulerService.addMeeting(meeting);
        meetingSchedulerService.scheduleMeeting(meeting, List.of(user2,user3));

        meetingSchedulerService.addMeeting(meeting1);
        meetingSchedulerService.scheduleMeeting(meeting1, List.of(user2));
        user1.showMeetings();
    }
}
