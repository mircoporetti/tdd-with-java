package me.mircoporetti.tddwithjava.marsrover.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTest {

    private Rover underTest;

    @BeforeEach
    void setUp() {
        Point point = new Point(0,0);
        underTest = new Rover(new Coordinate(point, Direction.N));
    }

    @Test
    void constructionWithPointAndDirection() {
        assertThat(underTest.getCoordinate().getPoint(), is(new Point(0,0)));
        assertThat(underTest.getCoordinate().getDirection(), is(Direction.N));
    }

    @Test
    void moveForwardSingleCommand() {
        underTest.execute("F");

        assertThat(underTest.getCoordinate().getPoint(), is(new Point(0,1)));
    }

    @Test
    void moveBackwardSingleCommand() {
        underTest.execute("B");

        assertThat(underTest.getCoordinate().getPoint(), is(new Point(0,-1)));
    }

    @Test
    void undefinedCommand() {
        assertThrows(IllegalStateException.class, () -> underTest.execute("C"));
    }

    @Test
    void turnLeftSingleCommand() {
        underTest.execute("L");

        assertThat(underTest.getCoordinate().getDirection(), is(Direction.W));
    }

    @Test
    void turnRightSingleCommand() {
        underTest.execute("R");

        assertThat(underTest.getCoordinate().getDirection(), is(Direction.E));
    }
}