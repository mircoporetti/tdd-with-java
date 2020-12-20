package me.mircoporetti.tddwithjava.christmaslights;

public class Light {

    private boolean on = false;

    public boolean isOn(){
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void toggle() {
        if(on){
            turnOff();
        }else{
            turnOn();
        }
    }
}
