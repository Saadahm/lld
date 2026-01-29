package TrafficLightSystem;

public class RedState extends TrafficState{

    public RedState(TrafficController trafficController)
    {
        super(trafficController,30);
    }
    @Override
    public void green2yellow() {

    }

    @Override
    public void yellow2red() {

    }

    @Override
    public void red2green() {
        System.out.println("Changing state from red to green");
        trafficController.setTrafficState(new GreenState(trafficController));

    }

    @Override
    public String getStateName() {
        return "RED";
    }
}
