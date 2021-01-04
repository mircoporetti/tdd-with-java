package me.mircoporetti.tddwithjava.ohce;

import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {
        Ohce ohce = new Ohce(new SystemConsole(), LocalTime.now());
        ohce.run();
    }
}
