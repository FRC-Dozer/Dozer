package com.saintsrobotics.framework.input.OI;

import edu.wpi.first.wpilibj.Joystick;

public abstract class Input {

  private final int pin;
  protected Joystick joystick;

  /**
   * Declares the class Input by setting the passed pin
   * @method Input
   * @param  int   pin           the number that references the pin
   */
  public Input(int pin) {
    this.pin = pin;
  }

  /**
   * Declares the pin as a joystick, allowing processing of  input
   * @method init
   */
  public void init() {
    joystick = new Joystick(pin);
  }

/**
 * Deadzone decleration for a base value of 0.10
 * @method deadzone
 * @param  double   rawAxis       the rawAxis value
 * @return          the deadzone
 */
  protected double deadzone(double rawAxis) {
    return deadzone(rawAxis, 0.10);
  }

/**
 * For a custom value of deadzone and a rawAxis, returns either a 0 or the rawAxis number.
 * @method deadzone
 * @param  double   rawAxis       value of the Axis
 * @param  double   deadzone      number for which rawAxis goes to zero
 * @return          either 0 or the rawAxis number.
 */
  protected double deadzone(double rawAxis, double deadzone) {
    if (Math.abs(rawAxis) < deadzone)
      return 0;
    else
      return rawAxis;
  }
}
