package com.github.dozer.output;

import edu.wpi.first.wpilibj.SpeedController;

public class MotorSimple implements Motor {
  private SpeedController speedController;

  MotorSimple(SpeedController speedController, boolean inverted) {
    this.speedController = speedController;
    this.speedController.setInverted(inverted);
  }

  private double setpoint = 0;
  private double current = 0;

  public double get(){
    return speedController.get();
  }


  public void set(double speed) {
    this.speedController.set(speed);
  }

  public void stop() {
    speedController.stopMotor();
  }
}
