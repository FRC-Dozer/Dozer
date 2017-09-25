package com.saintsrobotics.framework.output;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;

public class Motor {
    public static final double MOTOR_RAMPING = 0.01;
    
    private final int pin;
    private final boolean inverted;
    private SpeedController speedController;

    Motor(int pin, boolean inverted) {
    	//TODO Generic this in some way.
        this.pin = pin;
        this.inverted = inverted;
    }
    
    public void init() {
        speedController = new TalonSRX(pin);
        speedController.setInverted(inverted);
    }
    
    private double setpoint = 0;
    private double current = 0;
    
    
    public void set(double speed) {
        setpoint = speed;
    }

    public void stop() {
        speedController.stopMotor();
        setpoint = 0;
        current = 0;
    }

    public void update() {
        if (Math.abs(setpoint - current) < MOTOR_RAMPING) {
            current = setpoint;
        } else if (setpoint > current) {
            current += MOTOR_RAMPING;
        } else if (setpoint < current) {
            current -= MOTOR_RAMPING;
        }
        speedController.set(current);
    }
}
