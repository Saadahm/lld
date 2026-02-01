package PubSubSystem;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {
    private String id;
    private Topic topic;
    private ISubscriber subscriber;
    private AtomicInteger offset;

    public TopicSubscriber(Topic topic, ISubscriber iSubscriber)
    {
        this.id= UUID.randomUUID().toString();
        this.topic=topic;
        this.subscriber=iSubscriber;
        this.offset=new AtomicInteger(0);
    }
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
