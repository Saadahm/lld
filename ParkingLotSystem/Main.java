package ParkingLotSystem;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot lot=ParkingLot.getInstance();
        lot.initSpots(Map.of(
                VehicleType.CAR, 5,
                VehicleType.MOTORCYCLE, 3,
                VehicleType.TRUCK, 2
        ));
        lot.setPricingStrategy(new FlatRateStrategy(10.0));
        System.out.println("Welcome to Parking Lot Simulator");
        String choice;
        do {
            System.out.println("\nMenu: 1=Park, 2=Unpark, 3=Status, 4=Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter vehicle type (CAR, MOTORCYCLE, TRUCK): ");
                        VehicleType type = VehicleType.valueOf(scanner.nextLine().trim().toUpperCase());
                        System.out.print("Enter license plate: ");
                        String plate = scanner.nextLine().trim();
                        Vehicle v = VehicleFactory.createVehicle(type, plate);
                        Ticket ticket = lot.parkVehicle(v);
                        System.out.println("Parked! Ticket ID: " + ticket.getTicketId());
                    }
                    case "2" -> {
                        System.out.print("Enter ticket ID to unpark: ");
                        String ticketId = scanner.nextLine().trim();
                        double fee = lot.unparkVehicle(ticketId);
                        System.out.println("Unparked! Fee: $" + fee);
                    }
                    case "3" -> {
                        System.out.println("Free spots (CAR): " + lot.getFreeCount(VehicleType.CAR));
                        System.out.println("Free spots (MOTORCYCLE): " + lot.getFreeCount(VehicleType.MOTORCYCLE));
                        System.out.println("Free spots (TRUCK): " + lot.getFreeCount(VehicleType.TRUCK));
                    }
                    case "4" -> System.out.println("Exiting. Goodbye!");
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (!choice.equals("4"));

        scanner.close();
    }

    }

