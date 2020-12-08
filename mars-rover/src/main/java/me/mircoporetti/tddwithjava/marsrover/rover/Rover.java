package me.mircoporetti.tddwithjava.marsrover.rover;

import static me.mircoporetti.tddwithjava.marsrover.rover.Direction.*;

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

        if(command.equals("F")) {
            moveForward();
        }else if(command.equals("B")){
            moveBackward();
        }else if(command.equals("L")){
            turnLeft();
        }else{
            throw new IllegalStateException("Unexpected value: " + command);
        }
    }

    private void moveForward() {
        int x = point.getX();
        int y = point.getY();
        if (direction.equals(N)) {
            y += 1;
        } else if (direction.equals(S)) {
            y -= 1;
        } else if (direction.equals(W)) {
            x -= 1;
        } else {
            x += 1;
        }
        point = new Point(x, y);
    }

    private void moveBackward() {
        int x = point.getX();
        int y = point.getY();
        if(direction.equals(N)){
            y -= 1;
        }else if(direction.equals(S)){
            y += 1;
        }else if(direction.equals(W)){
            x += 1;
        }else{
            x -= 1;
        }
        point = new Point(x, y);
    }

    private void turnLeft() {
        if(direction.equals(N)){
            direction = W;
        }else if(direction.equals(S)){
            direction = E;
        }else if(direction.equals(W)){
            direction = S;
        }else{
            direction = N;
        }
    }
}
