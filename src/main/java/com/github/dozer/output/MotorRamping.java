package com.github.dozer.output;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class MotorRamping implements Motor{
  public static final double MOTOR_RAMPING = 0.01;

  private SpeedController speedController;

  MotorRamping(SpeedController speedController, boolean inverted) {
    this.speedController = speedController;
    this.speedController.setInverted(inverted);
  }

  private double setpoint = 0;
  private double current = 0;

  public double get(){
    return speedController.get();
  }


  public void set(double speed) {
    setpoint = speed;
  }

  public void stop() {
    speedController.stopMotor();
    setpoint = 0;
    current = 0;
  }

  public void update() {
    if (Math.abs(setpoint - current) < MOTOR_RAMPING) {
      current = setpoint;
    } else if (setpoint > current) {
      current += MOTOR_RAMPING;
    } else if (setpoint < current) {
      current -= MOTOR_RAMPING;
    }
    speedController.set(current);
  }
}
