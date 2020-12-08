package me.mircoporetti.tddwithjava.marsrover.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class RoverTest {

    private Rover underTest;

    @BeforeEach
    void setUp() {
        Point point = new Point(0,0);
        underTest = new Rover(point, Direction.N);
    }

    @Test
    void constructionWithPointAndDirection() {
        assertThat(underTest.getPoint(), is(new Point(0,0)));
        assertThat(underTest.getDirection(), is(Direction.N));
    }

    @Test
    void forwardCommand() {
        underTest.execute("F");

        assertThat(underTest.getPoint(), is(new Point(0,1)));
    }
}