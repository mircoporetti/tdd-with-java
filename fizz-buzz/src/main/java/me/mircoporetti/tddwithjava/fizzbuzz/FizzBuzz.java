package me.mircoporetti.tddwithjava.fizzbuzz;

public class FizzBuzz {

    public String fizzBuzz(int number) {
        return number % 3 == 0 ? "Fizz" : String.valueOf(number);
    }
}
