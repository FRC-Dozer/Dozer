package com.github.dozer.output;

import edu.wpi.first.wpilibj.Solenoid;

public class SingleSolenoid {
  private Solenoid solenoid;

  public SingleSolenoid(int pin) {
    this.solenoid = new Solenoid(pin);
  }


  //This used to be a double. Not sure why, since solenoid has only had a 
  public void set(boolean on) {
    solenoid.set(on);
  }
  
  public boolean get() {
    return solenoid.get();
  }
}
