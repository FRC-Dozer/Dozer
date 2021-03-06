package com.github.dozer.output;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class DoubleSolenoidWrapper {
  private final int pin1;
  private final int pin2;
  private DoubleSolenoid doubleSolenoid;

  public DoubleSolenoidWrapper(int pin1, int pin2) {
    // TODO Generic this in some way.
    this.pin1 = pin1;
    this.pin2 = pin2;
  }

  public void init() {
    doubleSolenoid = new DoubleSolenoid(pin1, pin2);
  }

  public void set(DoubleSolenoid.Value value) {
    doubleSolenoid.set(value);
  }
  
  public DoubleSolenoid.Value get() {
    return doubleSolenoid.get();
  }
}
