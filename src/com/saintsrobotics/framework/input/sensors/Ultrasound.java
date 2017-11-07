package com.saintsrobotics.framework.input.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class Ultrasound {

  private AnalogInput analog;
  private int pin;

/**
 * Initalize an Ultrasound class with a pin.
 * @method Ultrasound
 * @param  int        pin           the pin the physical ultrasound sensor corresponds to
 */
  public Ultrasound(int pin) {
    this.pin = pin;
  }

/**
 * Initalizes the ultrasound sensro through @see edu.wpi.first.wpilibj.AnalogInput
 * @method init
 */
  public void init() {
    if (analog == null)
      analog = new AnalogInput(pin);
  }

/**
 * Disables the ultrasound sensor, setting the AnalogInput pin to null.
 * @method disable
 */
  public void disable() {
    if (analog != null) {
      analog.free();
      analog = null;
    }
  }

  double[] lowPassQueue = new double[10];
  /**
   * Returns the distance as calculated by the Ultrasound sensor
   * @method getDistance
   * @return distance from ultrasound
   */
  public double getDistance() {
    return lowPassQueue[0];
    // double sum = 0;
    // for (double val : lowPassQueue) {
    // sum += val;
    // }
    // return sum / lowPassQueue.length;
  }

  /**
   * Updates the ultrasound sensor, pushing all other values down the lowPassQueue array in order to create a record.
   * @method update
   */
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
