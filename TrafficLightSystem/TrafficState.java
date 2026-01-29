package TrafficLightSystem;

public abstract class TrafficState {
    protected TrafficController trafficController;
    protected int duration;
    public TrafficState(TrafficController trafficController, int duration)
    {
        this.trafficController=trafficController;
        this.duration=duration;
    }
    public abstract void green2yellow();
    public abstract void yellow2red();
    public abstract void red2green();
    public abstract String getStateName();

    public int getDuration()
    {
        return duration;
    }
}
