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
    void moveForward() {
        underTest.executeSingle("F");

        assertThat(underTest.getCoordinate().getPoint(), is(new Point(0,1)));
    }

    @Test
    void moveBackward() {
        underTest.executeSingle("B");

        assertThat(underTest.getCoordinate().getPoint(), is(new Point(0,-1)));
    }

    @Test
    void turnLeft() {
        underTest.executeSingle("L");

        assertThat(underTest.getCoordinate().getDirection(), is(Direction.W));
    }

    @Test
    void turnRight() {
        underTest.executeSingle("R");

        assertThat(underTest.getCoordinate().getDirection(), is(Direction.E));
    }

    @Test
    void undefinedCommand() {
        assertThrows(IllegalStateException.class, () -> underTest.executeSingle("C"));
    }

    @Test
    void turnAndMoveSingleTime() {
        underTest.executeMultiple(new String[]{"L", "F"});

        assertThat(underTest.getCoordinate().getPoint(), is(new Point(-1,0)));
    }

    @Test
    void turnMultipleTimesAndMoveSingleTime() {
        underTest.executeMultiple(new String[]{"R", "R", "B"});

        assertThat(underTest.getCoordinate().getPoint(), is(new Point(0,1)));
    }

    @Test
    void turnSingleTimeAndMoveMultipleTimes() {
        underTest.executeMultiple(new String[]{"L", "B", "B"});

        assertThat(underTest.getCoordinate().getPoint(), is(new Point(2,0)));
    }

    @Test
    void turnAndMoveMultipleTimes() {
        underTest.executeMultiple(new String[]{"F", "R", "F", "L", "L", "B"});

        assertThat(underTest.getCoordinate().getPoint(), is(new Point(2,1)));
    }
}