package PubSubSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic {
    private final String id = UUID.randomUUID().toString();
    private final String name;
    private final List<Message> messages = new ArrayList<>();

    public Topic(String name) { this.name = name; }

    public String getId() { return id; }
    public String getName() { return name; }

    public synchronized void addMessage(Message message) {
        messages.add(message);
    }
    public synchronized int size() {
        return messages.size();
    }
    public synchronized Message get(int idx) {
        return messages.get(idx);
    }
}