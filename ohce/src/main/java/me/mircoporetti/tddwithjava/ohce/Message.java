package me.mircoporetti.tddwithjava.ohce;

import java.util.Objects;

public class Message {

    private final String text;

    public Message(String text) {
        this.text = text;
    }

    public String reverse(){
        StringBuilder stringBuilder = new StringBuilder(text);
        return stringBuilder.reverse().toString();
    }

    public boolean isStop() {
        return text.equals("Stop!");
    }

    public boolean isPalindrome() {
        return reverse().equals(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
