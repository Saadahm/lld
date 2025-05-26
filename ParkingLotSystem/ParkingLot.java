package ParkingLotSystem;

import java.util.*;

public class ParkingLot {
    private Map<VehicleType, Queue<ParkingSpot>> freeSpots = new HashMap<>();
    private PricingStrategy pricingStrategy;
    private Map<String, ParkingSpot> occupiedSpots = new HashMap<>();
    private Map<String, Ticket> activeTickets = new HashMap<>();
    private static ParkingLot instance;

    private ParkingLot(){

    }
    public static synchronized ParkingLot getInstance() {
        if (instance == null) instance = new ParkingLot();
        return instance;
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }
    public void initSpots(Map<VehicleType, Integer>counts)
    {
        for (Map.Entry<VehicleType, Integer> entry : counts.entrySet()) {
            VehicleType type = entry.getKey();
            int count = entry.getValue();
            Queue<ParkingSpot> queue = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                String spotId = type.name() + "-" + (i + 1);
                queue.add(new ParkingSpot(spotId, type));
            }
            freeSpots.put(type,queue);
        }
    }

    public Ticket parkVehicle(Vehicle vehicle)
    {
        Queue<ParkingSpot>spots=freeSpots.get(vehicle.getType());
        if (spots == null || spots.isEmpty())
            throw new RuntimeException("No spots available for " + vehicle.getType());
        ParkingSpot first=spots.poll();

        first.assignVehicle(vehicle);
        occupiedSpots.put(first.getId(), first);

        Ticket ticket = new Ticket(UUID.randomUUID().toString(), first);
        activeTickets.put(ticket.getTicketId(), ticket);

        return ticket;

    }
    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid ticket ID");

        ParkingSpot spot = occupiedSpots.remove(ticket.spotId);

        ticket.close();
        double fee = pricingStrategy.calculateFee(ticket.getParkingDuration());

        spot.removeVehicle();

        freeSpots.get(spot.getAllowed()).offer(spot);

        return fee;
    }

    public int getFreeCount(VehicleType type) {
        return freeSpots.getOrDefault(type, new LinkedList<>()).size();
    }

}
