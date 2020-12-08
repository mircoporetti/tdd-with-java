package me.mircoporetti.tddwithjava.marsrover.rover;

public class Rover {

    private Coordinate coordinate;

    public Rover(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void execute(String command) {
        if(command.equals("F")) {
            coordinate.moveForward();
        }else if(command.equals("B")){
            coordinate.moveBackward();
        }else if(command.equals("L")){
            coordinate.turnLeft();
        }else if(command.equals("R")){
            coordinate.turnRight();
        }else{
            throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
