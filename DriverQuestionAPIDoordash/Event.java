package DriverQuestionAPIDoordash;

public class Event {
    private String id;
    private String status;
    private String time;
    public Event(String id, String status, String time){
        this.status=status;
        this.id=id;
        this.time=time;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
