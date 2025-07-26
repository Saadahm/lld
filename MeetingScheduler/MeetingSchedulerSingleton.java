package MeetingScheduler;

import java.util.Map;

public class MeetingSchedulerSingleton {
    private Map<String, User> users;
    private Map<String, Meeting>meetings;
    void scheduleMeeting(String startTime, String endTime)
    {
        Meeting meeting= new Meeting(startTime, endTime, users,slot);
        meeting.schedule();
        meetings.put(meeting.getId(),meeitng);
    }
}
