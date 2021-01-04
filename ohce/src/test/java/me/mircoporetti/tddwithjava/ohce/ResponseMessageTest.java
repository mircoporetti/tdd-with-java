package me.mircoporetti.tddwithjava.ohce;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ResponseMessageTest {

    @Test
    void greetInTheMorning() {

        String result = ResponseMessage.greet("Mirco", LocalTime.of(8, 0));

        assertThat(result, is("¡Buenos días Mirco!"));
    }

    @Test
    void greetInTheAfternoon() {

        String result = ResponseMessage.greet("Mirco", LocalTime.of(16, 0));

        assertThat(result, is("¡Buenas tardes Mirco!"));
    }

    @Test
    void greetInTheNight() {

        String result = ResponseMessage.greet("Mirco", LocalTime.of(23, 0));

        assertThat(result, is("¡Buenas noches Mirco!"));
    }

}
