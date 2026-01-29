package TrafficLightSystem;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    private List<TrafficLight> trafficLights;

    public Intersection()
    {
        this.trafficLights = new ArrayList<>();
    }

    public void addTrafficLight(TrafficLight light)
    {
        trafficLights.add(light);
    }

    public void displayAll()
    {
        System.out.println("=== Intersection Status ===");
        for(TrafficLight light : trafficLights)
        {
            light.display();
        }
        System.out.println("===========================");
    }

    public void run(int cycles)
    {
        // Simple simulation: North-South and East-West alternate
        if(trafficLights.size() != 2) {
            System.out.println("This intersection requires exactly 2 traffic lights");
            return;
        }

        TrafficLight light1 = trafficLights.get(0);
        TrafficLight light2 = trafficLights.get(1);

        // Create separate controllers for each light
        TrafficController controller1 = new TrafficController();
        TrafficController controller2 = new TrafficController();

        // Set light2 to GREEN initially (opposite of RED which is default)
        controller2.setTrafficState(new GreenState(controller2));

        for(int i=0; i<cycles; i++)
        {
            System.out.println("\n--- Cycle " + (i+1) + " ---");
            light1.setCurrentState(controller1.getCurrentState());
            light2.setCurrentState(controller2.getCurrentState());
            displayAll();

            // Sleep for the duration of current state
            try {
                Thread.sleep(controller1.getCurrentState().getDuration() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Transition both controllers
            TrafficState state1 = controller1.getCurrentState();
            TrafficState state2 = controller2.getCurrentState();

            if(state1 instanceof RedState) {
                controller1.start(); // red to green
                controller2.pause(); // green to yellow
            } else if(state1 instanceof GreenState) {
                controller1.pause(); // green to yellow
            } else if(state1 instanceof YellowState) {
                controller1.stop(); // yellow to red
            }

            if(state2 instanceof GreenState) {
                controller2.pause(); // green to yellow
            } else if(state2 instanceof YellowState) {
                controller2.stop(); // yellow to red
                controller2.start(); // red to green
            }
        }

        System.out.println("\n--- Final State ---");
        light1.setCurrentState(controller1.getCurrentState());
        light2.setCurrentState(controller2.getCurrentState());
        displayAll();
    }
}
