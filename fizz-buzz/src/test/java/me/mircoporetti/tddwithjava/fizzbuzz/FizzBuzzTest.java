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
}