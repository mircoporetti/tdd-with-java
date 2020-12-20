package me.mircoporetti.tddwithjava.christmaslights;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HolidayHouseTest {

    private HolidayHouse underTest;

    @BeforeEach
    void setUp() {
        underTest = new HolidayHouse();
    }

    @Test
    void everyLightOffOnStart() {
        Light[][] lights = underTest.getLights();

        Stream.of(lights)
                .flatMap(Stream::of)
                .forEach(light -> assertThat(light.isOn(), is(false)));
    }

    @Test
    void turnEveryLightOn() {
        underTest.turnOnBetween(new Coordinate(0,0), new Coordinate(999,999));
        Light[][] lights = underTest.getLights();

        assertAreOnFromTo(lights, new Coordinate(0,0), new Coordinate(999,999));
    }

    @Test
    void toggleFirstLine() {
        underTest.toggleBetween(new Coordinate(0,0), new Coordinate(999,0));
        Light[][] lights = underTest.getLights();

        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){
                if(j == 0){
                    assertThat(lights[i][j].isOn(), is(true));
                }else{
                    assertThat(lights[i][j].isOn(), is(false));
                }
            }
        }
    }

    @Test
    void turnOffTheMiddleFourLights() {
        underTest.turnOnBetween(new Coordinate(0,0), new Coordinate(999,999));
        underTest.turnOffBetween(new Coordinate(499,499), new Coordinate(500,500));
        Light[][] lights = underTest.getLights();

        assertAreOnFromTo(lights, new Coordinate(0,0), new Coordinate(499,499));
        assertAreOnFromTo(lights, new Coordinate(501,501), new Coordinate(1000,1000));
        assertThat(lights[499][499].isOn(), is(false));
        assertThat(lights[499][500].isOn(), is(false));
        assertThat(lights[500][499].isOn(), is(false));
        assertThat(lights[500][500].isOn(), is(false));
    }

    private void assertAreOnFromTo(Light[][] lights, Coordinate firstCoordinate, Coordinate secondCoordinate) {
        for (int row = firstCoordinate.getX(); row < secondCoordinate.getX(); row++) {
            for (int col = secondCoordinate.getY(); col < secondCoordinate.getY(); col++) {
                assertThat(lights[row][col].isOn(), is(true));
            }
        }
    }
}