package ElevatorSystem;

import ElevatorSystem.enums.Direction;
import ElevatorSystem.enums.RequestSource;

public class Request {
    private int targetFloor;
    private RequestSource source;
    private Direction direction;

    public Request(int targetFloor, Direction direction, RequestSource source) {
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.source = source;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public RequestSource getSource() {
        return source;
    }

    @Override
    public String toString() {
        return source + " Request to floor " + targetFloor +
                (source == RequestSource.EXTERNAL ? " going " + direction : "");
    }
}
