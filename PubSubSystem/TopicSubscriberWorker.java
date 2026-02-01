package PubSubSystem;

public class TopicSubscriberWorker implements Runnable {
    private final TopicSubscriber ts;

    public TopicSubscriberWorker(TopicSubscriber ts) {
        this.ts = ts;
    }

    @Override
    public void run() {
        Topic topic = ts.getTopic();
        ISubscriber subscriber = ts.getSubscriber();
        while (!Thread.currentThread().isInterrupted()) {
            Message msg;

            synchronized (ts) {
                while (ts.getOffset().get() >= topic.size()) {
                    try {
                        ts.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                int idx = ts.getOffset().getAndIncrement();
                msg = topic.get(idx);
            }

            subscriber.onMessage(msg);
        }
    }
}