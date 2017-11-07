package com.saintsrobotics.framework.input.sensors;

import edu.wpi.first.wpilibj.DigitalInput;
import java.util.ArrayList;
import java.util.List;

/**
 * [LimitSwitch description]
 * @class LimitSwitch
 */
public class LimitSwitch {

  private final int pin;
  private DigitalInput switchInput;

  LimitSwitch(int pin) {
    this.pin = pin;
  }

  /**
   * [init description]
   * @method init
   */
  private void init() {
    if (switchInput == null)
      switchInput = new DigitalInput(pin);
  }
  /**
   * [disable description]
   * @method disable
   */
  private void disable() {
    if (switchInput != null) {
      switchInput.free();
      switchInput = null;
    }
  }

  /**
   * [get description]
   * @method get
   * @return [description]
   */
  public boolean get() {
    return switchInput.get();
  }
}
