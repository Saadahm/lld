package MeetingScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User implements  NotificationService{
    private String id;
    private String name;
    private List<Meeting>meetings;
    public User(String name)
    {
        this.id= UUID.randomUUID().toString();
        this.meetings=new ArrayList<>();
        this.name=name;
    }
    @Override
    public void update(User host)
    {
        System.out.println("Hi "+ this.name+ "there is a new invite from " + host.getName());
    }

    public void addMeeting(Meeting meeting)
    {
        meetings.add(meeting);
    }
    public String getName() {
        return name;
    }
    public void showMeetings()
    {
        for(Meeting meeting : meetings)
        {
            System.out.println(meeting.getStart().toString() + ">" + meeting.getEnd().toString());
        }
    }
    public String getId()
    {
        return id;
    }
}