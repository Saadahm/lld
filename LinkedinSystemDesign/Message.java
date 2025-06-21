package LinkedinSystemDesign;

import java.util.Date;
import java.util.UUID;

public class Message {
    private User from;
    private User to;
    private String id;
    private String content;
    private Date date;

    public Message(User to, User from, String content) {
        this.id= UUID.randomUUID().toString();
        this.to = to;
        this.from = from;
        this.content = content;
        this.date=new Date();
    }

    public User getFrom(){
        return from;
    }
    public User getTo() {
        return to;
    }
    public String getContent()
    {
        return content;
    }
}
