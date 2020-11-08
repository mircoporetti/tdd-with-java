package me.mircoporetti.tddwithjava.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GameTest {

    private Game underTest;

    @BeforeEach
    void setUp() {
        underTest = new Game();
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++)
            underTest.roll(pins);
    }

    @Test
    void singleRollWithNoPins() {
        underTest.roll(0);

        assertThat(underTest.score(), is(0));
    }

    @Test
    void singleRollWithOnePin() {
        underTest.roll(1);

        assertThat(underTest.score(), is(1));
    }

    @Test
    void rollManyWithNoPins() {
        rollMany(20,0);

        assertThat(underTest.score(), is(0));
    }

    @Test
    void rollManyWithAllOnePin() {
        rollMany(20,1);

        assertThat(underTest.score(), is(20));
    }


}