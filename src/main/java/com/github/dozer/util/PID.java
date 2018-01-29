package com.github.dozer.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PID {

  private final double maxSum;

  public double kp;
  private double ki;
  private double kd;

  private double lastError = 0;
  public double errorSum = 0;

  private double outMin = -1;
  private double outMax = 1;

  public PID(double kp, double ki, double kd, double maxSum) {
    this.kp = kp;
    this.ki = ki;
    this.kd = kd;
    this.maxSum = maxSum;
  }

  public double compute(double input, double setpoint) {
    double error = setpoint - input;

    this.errorSum += error * ki;
    if (this.errorSum < -this.maxSum)
      this.errorSum = -this.maxSum;
    if (this.errorSum > this.maxSum)
      this.errorSum = this.maxSum;

    SmartDashboard.putNumber("pid_error_sum", errorSum);

    double output = this.kp * error + this.errorSum - this.kd * (error - this.lastError);
    if (output < this.outMin)
      output = this.outMin;
    if (output > this.outMax)
      output = this.outMax;

    this.lastError = error;
    return output;
  }
}
