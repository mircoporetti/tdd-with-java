package me.mircoporetti.tddwithjava.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzzApp {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();

        IntStream.rangeClosed(1, 100).mapToObj(fizzBuzz::fizzBuzz).forEach(System.out::println);
    }
}
