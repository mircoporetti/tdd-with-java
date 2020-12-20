package me.mircoporetti.tddwithjava.christmaslights;

public class HolidayHouse {

    private Light[][] lights = new Light[999][999];

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

    public void turnOn(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        for (int i = firstCoordinate.getX(); i < secondCoordinate.getX(); i++){
            for (int j = firstCoordinate.getY(); j < secondCoordinate.getY(); j++){
                lights[i][j].turnOn();
            }
        }
    }
}