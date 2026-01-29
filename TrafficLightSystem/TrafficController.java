package TrafficLightSystem;

public class TrafficController {
    private static TrafficController trafficControllerInstance;
    private TrafficState trafficState;
    public TrafficController()
    {
        this.trafficState=new RedState(this);
    }
    public static TrafficController getInstance()
    {
        if(trafficControllerInstance==null)
        {
            synchronized (TrafficController.class)
            {
                if(trafficControllerInstance==null)
                    trafficControllerInstance=new TrafficController();
            }
        }
        return trafficControllerInstance;
    }
    public void setTrafficState(TrafficState trafficState)
    {
        this.trafficState=trafficState;
    }
    public void start()
    {
        trafficState.red2green();
    }
    public void pause()
    {
        trafficState.green2yellow();
    }
    public void stop()
    {
        trafficState.yellow2red();
    }

    public TrafficState getCurrentState()
    {
        return trafficState;
    }

    public void run(int cycles)
    {
        for(int i=0; i<cycles; i++)
        {
            System.out.println("Cycle " + (i+1) + ": Current state - " + getCurrentState());
            try {
                Thread.sleep(trafficState.getDuration() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(trafficState instanceof RedState) {
                trafficState.red2green();
            } else if(trafficState instanceof GreenState) {
                trafficState.green2yellow();
            } else if(trafficState instanceof YellowState) {
                trafficState.yellow2red();
            }
        }
        System.out.println("Final state - " + getCurrentState());
    }

}
