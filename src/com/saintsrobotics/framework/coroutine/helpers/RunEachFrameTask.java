package com.saintsrobotics.framework.coroutine.helpers;

import com.saintsrobotics.framework.coroutine.Task;
/**
 * Has the task run every frame of time using waiters.
 * 
 * @class RunEachFrameTask
 */
public abstract class RunEachFrameTask extends Task {

  @Override
  protected void runTask() {
    while (true) {
      runEachFrame();
      wait.forFrame();
    }
  }

  /**
   * Runs this method once per frame. Don't wait inside.
   */
  protected abstract void runEachFrame();
}
