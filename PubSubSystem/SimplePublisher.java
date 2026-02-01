package PubSubSystem;

public class SimplePublisher implements IPublisher{
    private final String id;
    private final PubSubController pubSubController;

    public SimplePublisher(String id, PubSubController pubSubController) {
        this.id = id;
        this.pubSubController = pubSubController;
    }

    @Override
    public void publish(String topicId, Message message) throws IllegalArgumentException {
        pubSubController.publish(this, topicId, message);
        System.out.println("Publisher " + id + " published: " + message.getMessage() + " to topic " + topicId);
    }
    public String getId() {
        return id;
    }
}
