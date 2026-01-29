package TrafficLightSystem;

public class TrafficLight {
    private String id;
    private TrafficState currentState;

    public TrafficLight(String id, TrafficState initialState)
    {
        this.id = id;
        this.currentState = initialState;
    }

    public String getId()
    {
        return id;
    }

    public TrafficState getCurrentState()
    {
        return currentState;
    }

    public void setCurrentState(TrafficState state)
    {
        this.currentState = state;
    }

    public String getStateName()
    {
        return currentState.getStateName();
    }

    public void display()
    {
        System.out.println(id + " Light: " + getStateName());
    }
}
