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

  //This used to be a double. Not sure why, since solenoid has only had a 
  public void set(boolean on) {
    solenoid.set(on);
  }
  
  public boolean get() {
    return solenoid.get();
  }
}
