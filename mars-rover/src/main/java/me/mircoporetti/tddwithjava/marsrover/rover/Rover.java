package me.mircoporetti.tddwithjava.marsrover.rover;

public class Rover {
    
    private Point point;
    private Direction direction;

    public Rover(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public Point getPoint() {
        return point;
    }

    public Direction getDirection() {
        return direction;
    }

    public void execute(String command) {

        switch (command){
            case "F":
                point = new Point(point.getX(),point.getY() + 1);
                break;
            case "B":
                point = new Point(point.getX(), point.getY() - 1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
