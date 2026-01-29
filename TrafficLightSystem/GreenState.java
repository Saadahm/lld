package TrafficLightSystem;

public class GreenState extends TrafficState{

    public GreenState(TrafficController trafficController)
    {
        super(trafficController, 30);
    }
    @Override
    public void green2yellow() {
        System.out.println("Changing state from green to yellow");
        trafficController.setTrafficState(new YellowState(trafficController));
    }

    @Override
    public void yellow2red() {

    }

    @Override
    public void red2green() {

    }

    @Override
    public String getStateName() {
        return "GREEN";
    }
}

