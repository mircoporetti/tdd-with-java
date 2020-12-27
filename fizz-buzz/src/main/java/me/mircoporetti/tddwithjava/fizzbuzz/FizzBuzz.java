package me.mircoporetti.tddwithjava.fizzbuzz;

public class FizzBuzz {

    public String fizzBuzz(int number) {
        if(number%3 == 0){
            return "Fizz";
        }

        return String.valueOf(number);
    }
}
