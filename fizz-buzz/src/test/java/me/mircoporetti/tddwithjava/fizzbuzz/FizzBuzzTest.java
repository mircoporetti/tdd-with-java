package me.mircoporetti.tddwithjava.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FizzBuzzTest {

    private FizzBuzz underTest;

    @BeforeEach
    void setUp() {
        underTest = new FizzBuzz();
    }

    @Test
    void returnTheGivenNumber() {
        String result = underTest.fizzBuzz(1);

        assertThat(result, is(String.valueOf(1)));
    }

    @Test
    void fizz() {
        String result = underTest.fizzBuzz(3);

        assertThat(result, is("Fizz"));
    }

}