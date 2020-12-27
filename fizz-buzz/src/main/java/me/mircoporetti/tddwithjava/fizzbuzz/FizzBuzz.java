package me.mircoporetti.tddwithjava.fizzbuzz;

public class FizzBuzz {

    public String fizzBuzz(int number) {
        String result = "";

        if(number % 3 == 0) {
            result = "Fizz";
        }
        if(number % 5 == 0){
            result += "Buzz";
        }

        return !result.isEmpty() ? result : String.valueOf(number);
    }
}
