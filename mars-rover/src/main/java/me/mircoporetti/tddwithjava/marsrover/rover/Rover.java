package me.mircoporetti.tddwithjava.marsrover.rover;

import java.util.Arrays;

public class Rover {

    private Coordinate coordinate;

    public Rover(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void executeSingle(String command) {
        switch (command) {
            case "F":
                coordinate.moveForward();
                break;
            case "B":
                coordinate.moveBackward();
                break;
            case "L":
                coordinate.turnLeft();
                break;
            case "R":
                coordinate.turnRight();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }

    public void executeMultiple(String[] commands) {
        Arrays.stream(commands).forEach(this::executeSingle);
    }
}
