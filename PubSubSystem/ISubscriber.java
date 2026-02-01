package PubSubSystem;

public interface ISubscriber {
    String getId();
    void onMessage(Message message);
}
