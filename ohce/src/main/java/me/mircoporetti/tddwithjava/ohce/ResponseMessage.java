package me.mircoporetti.tddwithjava.ohce;

import java.time.LocalTime;

public class ResponseMessage {

    public static String requestUserNameInput() {
        return "Write your name to start";
    }

    public static String greet(String userName, LocalTime startTime) {
        if(startTime.isAfter(LocalTime.of(5,59)) && startTime.isBefore(LocalTime.of(12,0))){
            return "¡Buenos días " + userName + "!";
        }else if (startTime.isAfter(LocalTime.of(11,59)) && startTime.isBefore(LocalTime.of(20,0))){
            return "¡Buenas tardes " + userName + "!";
        }else{
            return "¡Buenas noches " + userName + "!";
        }
    }

    public static String congratsForPalindrome() {
        return "¡Bonita palabra!";
    }

    public static String goodBye(String userName) {
        return "Adios " + userName;
    }
}
