package PubSubSystem;

public interface IPublisher {
    void publish(String topicID, Message message);
}
