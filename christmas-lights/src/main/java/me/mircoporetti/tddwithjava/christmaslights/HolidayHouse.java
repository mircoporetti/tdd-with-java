package me.mircoporetti.tddwithjava.christmaslights;

import java.util.function.Consumer;

public class HolidayHouse {

    private Light[][] lights = new Light[1000][1000];

    public HolidayHouse() {
        for (int i = 0; i < lights.length; i++){
            for (int j = 0; j < lights.length; j++){
                lights[i][j] = new Light();
            }
        }
    }

    public Light[][] getLights() {
        return lights;
    }

    public void turnOnBetween(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        eachLight(firstCoordinate, secondCoordinate, Light::turnOn);
    }

    public void turnOffBetween(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        eachLight(firstCoordinate, secondCoordinate, Light::turnOff);
    }

    public void toggleBetween(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        eachLight(firstCoordinate, secondCoordinate, Light::toggle);
    }

    public void eachLight(Coordinate firstCoordinate, Coordinate secondCoordinate, Consumer<Light> consumer){
        for (int row = firstCoordinate.getX(); row <= secondCoordinate.getX(); row++){
            for (int col = firstCoordinate.getY(); col <= secondCoordinate.getY(); col++){
                consumer.accept(lights[row][col]);
            }
        }
    }
}