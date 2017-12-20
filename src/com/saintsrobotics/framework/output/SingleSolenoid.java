package com.saintsrobotics.framework.output;

import edu.wpi.first.wpilibj.Solenoid;

public class SingleSolenoid {
  private final int pin;
  private Solenoid solenoid;

  SingleSolenoid(int pin) {
    // TODO Generic this in some way.
    this.pin = pin;
  }

  public void init() {
    solenoid = new Solenoid(pin);
  }

  public void set(double on) {
    solenoid.set(on);
  }
  
  public boolean get() {
    return solenoid.get();
  }
}
