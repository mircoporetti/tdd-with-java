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
        underTest.turnOn(new Coordinate(0,0), new Coordinate(999,999));
        Light[][] lights = underTest.getLights();

        Stream.of(lights)
                .flatMap(Stream::of)
                .forEach(light -> assertThat(light.isOn(), is(true)));
    }

    @Test
    void toggleFirstLine() {
        underTest.toggle(new Coordinate(0,0), new Coordinate(999,0));
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
        underTest.turnOn(new Coordinate(0,0), new Coordinate(999,999));
        underTest.turnOff(new Coordinate(499,499), new Coordinate(500,500));
        Light[][] lights = underTest.getLights();

        for (int i = 0; i < 499; i++){
            for (int j = 0; j < 499; j++){
                assertThat(lights[i][j].isOn(), is(true));
            }
        }
        for (int i = 501; i < 1000; i++){
            for (int j = 501; j < 1000; j++){
                assertThat(lights[i][j].isOn(), is(true));
            }
        }
        assertThat(lights[499][499].isOn(), is(false));
        assertThat(lights[499][500].isOn(), is(false));
        assertThat(lights[500][499].isOn(), is(false));
        assertThat(lights[500][500].isOn(), is(false));
    }
}