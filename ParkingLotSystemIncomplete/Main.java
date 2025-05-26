package ParkingLotSystemIncomplete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingSpot1 parkingSpot1= new ParkingSpot1(new Truck());
        ParkingSpot1 parkingSpot2= new ParkingSpot1(new Car());
        List<ParkingSpot1> parkingSpots = new ArrayList<>();
        parkingSpots.add(parkingSpot1);
        parkingSpots.add(parkingSpot2);

        ParkingLot1 parkingLot = new ParkingLot1(parkingSpots);
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String inputVehicle=scanner.nextLine();
            String operation=scanner.nextLine();
            Vehicle vehicle;
            if(inputVehicle.equals("truck"))
                vehicle=new Truck();
            else if(inputVehicle.equals("car"))
                vehicle=new Car();
            else
                break;
            parkingLot.park(vehicle, operation);
        }

    }
}
