package com.github.dozer.output;

import edu.wpi.first.wpilibj.Servo;

public class ServoWrapper {

  private final int pin;
  private Servo servo;

  ServoWrapper(int pin) {
    this.pin = pin;
  }

  void init() {
    if (pin != -1) {
      servo = new Servo(pin);
    }
  }

  public void setAngle(double degrees) {
    if (pin != -1) {
      servo.setAngle(degrees);
    }
  }
}
