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
                .forEach(light -> assertThat(light.on, is(false)));
    }
}