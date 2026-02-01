package PubSubSystem;

public class SimpleSubscriber implements ISubscriber{
    private final String id;
    public SimpleSubscriber(String id){
        this.id=id;
    }
    @Override
    public void onMessage(Message message){
        System.out.println("Subscriber received: " + message.getMessage());
    }
    @Override
    public String getId()
    {
        return id;
    }
}
