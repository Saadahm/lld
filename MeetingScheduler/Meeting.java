package MeetingScheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Meeting {
    private String id;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<User>participants=new ArrayList<>();
    private User host;


    public Meeting(LocalDateTime start, LocalDateTime end, User host)
    {
        this.id= UUID.randomUUID().toString();
        this.start=start;
        this.end=end;
        this.host=host;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }



    public void addParticipant(User user)
    {
        participants.add(user);
    }

    public String getId() {
        return id;
    }

    public User getHost() {
        return host;
    }
}