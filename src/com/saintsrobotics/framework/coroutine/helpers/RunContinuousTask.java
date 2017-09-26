package com.saintsrobotics.framework.coroutine.helpers;

import com.saintsrobotics.framework.coroutine.Task;

public abstract class RunContinuousTask extends Task {

  @Override
  protected void runTask() {
    while (true) {
      runContinuously();
    }
  }

  /**
   * Runs this method in a while loop. Must wait inside.
   */
  protected abstract void runContinuously();
}
