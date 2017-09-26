package com.saintsrobotics.framework.input.OI;

import edu.wpi.first.wpilibj.Joystick;

public abstract class Input {

  private final int pin;
  protected Joystick joystick;

  public Input(int pin) {
    this.pin = pin;
  }

  public void init() {
    joystick = new Joystick(pin);
  }

  protected double deadzone(double rawAxis) {
    return deadzone(rawAxis, 0.10);
  }

  protected double deadzone(double rawAxis, double deadzone) {
    if (Math.abs(rawAxis) < deadzone)
      return 0;
    else
      return rawAxis;
  }
}
