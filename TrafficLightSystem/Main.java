package TrafficLightSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Single Traffic Light Test ===\n");

        TrafficController controller = TrafficController.getInstance();
        System.out.println("Running single light for 3 cycles...\n");
        controller.run(3);

        System.out.println("\n\n=== Intersection with 2 Traffic Lights Test ===\n");

        Intersection intersection = new Intersection();
        TrafficLight northSouthLight = new TrafficLight("North-South", new RedState(null));
        TrafficLight eastWestLight = new TrafficLight("East-West", new GreenState(null));

        intersection.addTrafficLight(northSouthLight);
        intersection.addTrafficLight(eastWestLight);

        System.out.println("Running intersection simulation for 4 cycles...\n");
        intersection.run(4);
    }
}
