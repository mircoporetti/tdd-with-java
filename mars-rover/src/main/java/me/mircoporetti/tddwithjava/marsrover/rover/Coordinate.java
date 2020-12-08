package me.mircoporetti.tddwithjava.marsrover.rover;

import java.util.Objects;

import static me.mircoporetti.tddwithjava.marsrover.rover.Direction.*;
import static me.mircoporetti.tddwithjava.marsrover.rover.Direction.S;

public class Coordinate {
    private Point point;
    private Direction direction;

    public Coordinate(Point initialPoint, Direction initialDirection) {
        this.point = initialPoint;
        this.direction = initialDirection;
    }

    public Point getPoint() {
        return point;
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveForward() {
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

    public void moveBackward() {
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

    public void turnLeft() {
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

    public void turnRight() {
        if(direction.equals(N)){
            direction = E;
        }else if(direction.equals(S)){
            direction = W;
        }else if(direction.equals(W)){
            direction = N;
        }else{
            direction = S;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(point, that.point) &&
                direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, direction);
    }
}
