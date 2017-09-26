package com.saintsrobotics.framework.input.sensors;

import edu.wpi.first.wpilibj.DigitalInput;
import java.util.ArrayList;
import java.util.List;

public class LimitSwitch {

  private final int pin;
  private DigitalInput switchInput;

  LimitSwitch(int pin) {
    this.pin = pin;
  }

  private void init() {
    if (switchInput == null)
      switchInput = new DigitalInput(pin);
  }

  private void disable() {
    if (switchInput != null) {
      switchInput.free();
      switchInput = null;
    }
  }

  public boolean get() {
    return switchInput.get();
  }
}
