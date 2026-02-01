package PubSubSystem;

import java.util.UUID;

public class Message {
    private String id;
    private String message;
    public Message(String message)
    {
        this.id= UUID.randomUUID().toString();
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
