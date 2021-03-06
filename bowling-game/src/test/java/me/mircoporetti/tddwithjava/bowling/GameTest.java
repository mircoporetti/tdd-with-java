package me.mircoporetti.tddwithjava.bowling;

import me.mircoporetti.tddwithjava.bowling.exception.TooManyGamesException;
import me.mircoporetti.tddwithjava.bowling.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void aSpare() {
        underTest.roll(4);
        underTest.roll(6);
        underTest.roll(5);

        rollMany(17, 0);

        assertThat(underTest.score(), is(20));
    }

    @Test
    void aStrike() {
        underTest.roll(10);
        underTest.roll(4);
        underTest.roll(5);

        rollMany(16, 0);

        assertThat(underTest.score(), is(28));
    }

    @Test
    void tooManyGames() {

        rollMany(20,1);
        assertThrows(TooManyGamesException.class, () -> underTest.roll(1));
    }

    @Test
    void noSpareOrStrikeInTheLastFrame() {
        rollMany(18, 0);

        underTest.roll(4);
        underTest.roll(5);

        assertThat(underTest.score(), is(9));
    }

    @Test
    void spareInTheLastFrame() {
        rollMany(18, 0);

        underTest.roll(4);
        underTest.roll(6);
        underTest.roll(5);


        assertThat(underTest.score(), is(15));
    }

    @Test
    void strikeInTheLastFrame() {
        rollMany(18, 0);

        underTest.roll(10);
        underTest.roll(5);
        underTest.roll(5);

        assertThat(underTest.score(), is(20));
    }

    @Test
    void doubleStrikeInTheLastFrame() {
        rollMany(18, 0);

        underTest.roll(10);
        underTest.roll(10);
        underTest.roll(5);

        assertThat(underTest.score(), is(25));
    }

    @Test
    void perfectGame() {
        rollMany(12, 10);

        assertThat(underTest.score(), is(300));
    }
}
