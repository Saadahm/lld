package PubSubSystem;

public class Main {
    public static void main(String[] args) throws Exception {
        PubSubController pubSubController=new PubSubController();
        SimplePublisher publisher1=new SimplePublisher("Publisher 1", pubSubController);

        String topicId = pubSubController.addTopic("Topic1");

        Message message=new Message("Hello");

        SimpleSubscriber subscriber1=new SimpleSubscriber("S1");
        SimpleSubscriber subscriber2=new SimpleSubscriber("S2");

        pubSubController.addSubscriber(topicId, subscriber1);
        pubSubController.addSubscriber(topicId, subscriber2);

        publisher1.publish(topicId, message);
        Thread.sleep(200);
    }
}
