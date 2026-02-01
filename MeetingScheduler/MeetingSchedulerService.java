package MeetingScheduler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MeetingSchedulerService {
    private static MeetingSchedulerService instance;
    private Map<String, Meeting>meetings=new ConcurrentHashMap<>();
    private Map<String, User>users=new ConcurrentHashMap<>();
    public static MeetingSchedulerService getInstance()
    {
        if(instance==null)
            instance=new MeetingSchedulerService();
        return instance;
    }
    public void addMeeting(Meeting meeting)
    {
        meetings.put(meeting.getId(), meeting);
    }
    public void scheduleMeeting(Meeting meeting, List<User> participants)
    {
        meeting.getHost().addMeeting(meeting);
        meeting.addParticipant(meeting.getHost());
        for(User user: participants)
        {
            user.addMeeting(meeting);
            meeting.addParticipant(user);
            user.update(meeting.getHost());
        }

    }

    public void addUser(User user)
    {
        users.put(user.getId(), user);
    }
}
