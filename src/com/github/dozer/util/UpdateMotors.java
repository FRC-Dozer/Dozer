package com.github.dozer.util;


import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.output.Motors;

public class UpdateMotors extends RunEachFrameTask {
  private Motors motors;

  public UpdateMotors(Motors motors) {
    this.motors = motors;
  }

  @Override
  protected void runEachFrame() {
    motors.update();
  }
}
