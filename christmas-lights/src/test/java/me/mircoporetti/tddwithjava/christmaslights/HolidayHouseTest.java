package me.mircoporetti.tddwithjava.christmaslights;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        boolean[][] lights = underTest.getLights();

        for(int x = 0; x < 999; x++){
            for(int y = 0; y < 999; y++){
                assertThat(lights[x][y], is(false));
            }
        }
    }
}