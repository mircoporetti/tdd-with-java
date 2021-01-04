package me.mircoporetti.tddwithjava.ohce;

import java.time.LocalTime;

public class Ohce {

    private final Console console;
    private final LocalTime startTime;

    public Ohce(Console console, LocalTime startTime) {
        this.console = console;
        this.startTime = startTime;
    }

    public void run(){
        console.print(ResponseMessage.requestUserNameInput());
        String userName = console.read();
        console.print(ResponseMessage.greet(userName, startTime));

        do{
            Message inputMessage = new Message(console.read());
            if (inputMessage.isStop()) {
                console.print(ResponseMessage.goodBye(userName));
                break;
            }
            else {
                console.print(inputMessage.reverse());
                if (inputMessage.isPalindrome())
                    console.print(ResponseMessage.congratsForPalindrome());
            }
        }while(true);

    }
}
