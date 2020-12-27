package me.mircoporetti.tddwithjava.fizzbuzz;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    private FizzBuzz underTest;

    @BeforeEach
    void setUp() {
        underTest = new FizzBuzz();
    }

    @Test
    void returnTheSameNumber() {
        String result = underTest.fizzBuzz(1);

        assertThat(result, Matchers.is("1"));
    }

    @Test
    void numberIsDivisibleByThree_fizz() {
        String result = underTest.fizzBuzz(3);

        assertThat(result, Matchers.is("Fizz"));
    }

    @Test
    void numberIsDivisibleByFive_buzz() {
        String result = underTest.fizzBuzz(5);

        assertThat(result, Matchers.is("Buzz"));
    }

    @Test
    void numberIsDivisibleByThreeAndFive_fizzbuzz() {
        String result = underTest.fizzBuzz(15);

        assertThat(result, Matchers.is("FizzBuzz"));
    }
}