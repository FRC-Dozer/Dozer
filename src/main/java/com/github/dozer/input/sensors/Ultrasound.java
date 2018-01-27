package com.github.dozer.input.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class Ultrasound {

  private AnalogInput analog;
  private int pin;

  public Ultrasound(int pin) {
    this.pin = pin;
  }

  public void init() {
    if (analog == null)
      analog = new AnalogInput(pin);
  }

  public void disable() {
    if (analog != null) {
      analog.free();
      analog = null;
    }
  }

  double[] lowPassQueue = new double[10];

  public double getDistance() {
    return lowPassQueue[0];
    // double sum = 0;
    // for (double val : lowPassQueue) {
    // sum += val;
    // }
    // return sum / lowPassQueue.length;
  }

  public void update() {
    double val = (2.2 - analog.getAverageVoltage()) * 40 / 2.2 - 3;// * 53.72 - 5.62;
    // double val = analog.getAverageVoltage() * 53.72 - 5.62;
    // if (val > 220) val = lowPassQueue[0];
    lowPassQueue[0] = val;
    for (int i = 0; i < lowPassQueue.length - 1; i++) {
      lowPassQueue[i + 1] = lowPassQueue[i];
    }
  }
}
