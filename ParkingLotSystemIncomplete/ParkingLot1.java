package ParkingLotSystemIncomplete;

import java.util.List;
import java.util.Objects;

public class ParkingLot1 {
    List<ParkingSpot1> parkingSpots;
    public ParkingLot1(List<ParkingSpot1>parkingSpots){
        this.parkingSpots=parkingSpots;
    }

    void  park(Vehicle vehicle, String operation)
    {
        if(Objects.equals(operation, "exit"))
        {
            System.out.println("You have taken out the car successfully");
            parkingSpots.add(new ParkingSpot1(vehicle));
            return;
        }
        if(parkingSpots.isEmpty())
        {
            System.out.println("No parking spot available");
            return;
        }
        for(ParkingSpot1 p: parkingSpots){
            if (p.vehicle.getClass() == vehicle.getClass())
            {
                System.out.println("You have Parked successfully");
                parkingSpots.remove(p);
                return;
            }
        }
        System.out.println("No parking spot available");
    }


}
