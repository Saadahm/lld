package TrafficLightSystem;

public class YellowState extends TrafficState{

    public YellowState(TrafficController trafficController)
    {
        super(trafficController,5);
    }
    @Override
    public void green2yellow() {

    }

    @Override
    public void yellow2red() {
        System.out.println("Changing state from yellow to red");
        trafficController.setTrafficState(new RedState(trafficController));
    }

    @Override
    public void red2green() {

    }

    @Override
    public String getStateName() {
        return "YELLOW";
    }
}
