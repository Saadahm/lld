package PubSubSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PubSubController {
    Map<String, Map<String, TopicSubscriber>>m=new ConcurrentHashMap<>(); //for this topic list of topic subscribers
    Map<String , Topic> topics= new ConcurrentHashMap<>();

    public void publish(IPublisher publisher, String topicId, Message message)
    {
        Topic topic = topics.get(topicId);
        if(topic == null) {
            System.out.println("Topic not found: " + topicId);
            return;
        }

        topic.addMessage(message);

        Map<String, TopicSubscriber>cur=m.get(topicId);
        if(cur == null || cur.isEmpty()) {
            System.out.println("No subscribers for topic: " + topicId);
            return;
        }

        for(TopicSubscriber topicSubscriber: cur.values())
        {
            synchronized (topicSubscriber)
            {
                topicSubscriber.notifyAll();
            }
        }
    }

    public String addTopic(String name)
    {
        Topic topic=new Topic(name);
        topics.put(topic.getId(),topic);
        System.out.println("Created topic: " + topic.getName() + " with id: " + topic.getId());
        return topic.getId();
    }

    public void addSubscriber(String topicId, ISubscriber subscriber){
        Topic topic=topics.get(topicId);
        if(topic == null) {
            System.out.println("Topic not found: " + topicId);
            return;
        }

        TopicSubscriber topicSubscriber= new TopicSubscriber(topic, subscriber);
        m.putIfAbsent(topicId, new ConcurrentHashMap<>());
        m.get(topicId).put(topicSubscriber.getId(), topicSubscriber);
        Thread t = new Thread(new TopicSubscriberWorker(topicSubscriber),
                "sub-" + subscriber.getId() + "-topic-" + topicId);
        t.setDaemon(true);
        t.start();

        System.out.println("Subscriber " + subscriber.getId() + " subscribed to " + topic.getName());
    }
}
