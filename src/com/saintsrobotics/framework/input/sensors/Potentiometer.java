package com.saintsrobotics.framework.input.sensors;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Potentiometer {
    
    private int pin;
    private AnalogPotentiometer pot;
    
    public Potentiometer(int pin) {
        this.pin = pin;
    }
    
    public void init() {
        pot = new AnalogPotentiometer(pin, 270, 0);
    }
    
    public double get() {
        return pot.get();
    }
    
    public void disable() {
        if (pot != null) {
            pot.free();
        }
        pot = null;
    }
}
