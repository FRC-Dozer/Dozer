package com.github.dozer.input.OI;

public class XboxInput extends Input {

  public XboxInput(int pin) {
    super(pin);
  }

  public boolean A() {
    return joystick.getRawButton(1);
  }

  public boolean B() {
    return joystick.getRawButton(2);
  }

  public boolean X() {
    return joystick.getRawButton(3);
  }

  public boolean Y() {
    return joystick.getRawButton(4);
  }

  public boolean LB() {
    return joystick.getRawButton(5);
  }

  public boolean RB() {
    return joystick.getRawButton(6);
  }

  public boolean SELECT() {
    return joystick.getRawButton(7);
  }

  public boolean START() {
    return joystick.getRawButton(8);
  }

  public boolean L3() {
    return joystick.getRawButton(9);
  }

  public boolean R3() {
    return joystick.getRawButton(10);
  }

  public boolean DPAD_UP() {
    return joystick.getPOV(0) == 0;
  }

  public boolean DPAD_RIGHT() {
    return joystick.getPOV(0) == 90;
  }

  public boolean DPAD_DOWN() {
    return joystick.getPOV(0) == 180;
  }

  public boolean DPAD_LEFT() {
    return joystick.getPOV(0) == 270;
  }

  public double leftStickX() {
    return deadzone(joystick.getRawAxis(0));
  }

  public double leftStickY() {
    return deadzone(joystick.getRawAxis(1));
  }

  public double leftTrigger() {
    return deadzone(joystick.getRawAxis(2));
  }

  public double rightTrigger() {
    return deadzone(joystick.getRawAxis(3), 0.05);
  }

  public double rightStickX() {
    return deadzone(joystick.getRawAxis(4), 0.05);
  }

  public double rightStickY() {
    return deadzone(joystick.getRawAxis(5));
  }

}
