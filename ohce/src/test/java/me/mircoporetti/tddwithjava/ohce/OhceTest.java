package me.mircoporetti.tddwithjava.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalTime;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class OhceTest {

    @Mock
    private Console console;

    private Ohce underTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        underTest = new Ohce(console, LocalTime.of(0,0));
    }

    @Test
    void userWriteHisNameAndThenStop() {
        doReturn("Mirco").doReturn("Stop!").when(console).read();

        underTest.run();

        verify(console).print(ResponseMessage.requestUserNameInput());
        verify(console).print(ResponseMessage.greet("Mirco", LocalTime.of(0,0)));
        verify(console).print(ResponseMessage.goodBye("Mirco"));
    }

    @Test
    void userWriteAWord() {
        doReturn("Mirco").doReturn("aWord").doReturn("Stop!").when(console).read();

        underTest.run();

        verify(console).print("droWa");
    }

    @Test
    void userWriteAPalindromeWord() {
        doReturn("Mirco").doReturn("lol").doReturn("Stop!").when(console).read();

        underTest.run();

        verify(console).print("lol");
        verify(console).print(ResponseMessage.congratsForPalindrome());
    }

    @Test
    void userWriteANonPalindromeThenAPalindromeAndThenStop() {
        doReturn("Mirco")
                .doReturn("aWord")
                .doReturn("lol")
                .doReturn("Stop!")
                .when(console).read();

        underTest.run();

        verify(console).print("droWa");
        verify(console).print("lol");
        verify(console).print(ResponseMessage.congratsForPalindrome());
        verify(console).print(ResponseMessage.goodBye("Mirco"));
    }

    @Test
    void reallyStopToListenForWords() {
        doReturn("Mirco")
                .doReturn("Stop!")
                .doReturn("Something")
                .when(console).read();

        underTest.run();

        verify(console, never()).print(ResponseMessage.goodBye("gnihtemoS"));
    }
}
