package ElevatorSystem;

import ElevatorSystem.enums.Direction;

public interface ElevatorState {
    void move(Elevator elevator);
    void addRequest(Elevator elevator, Request request);
    Direction getDirection();
}