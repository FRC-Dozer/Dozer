package com.github.dozer.coroutine.helpers;

import com.github.dozer.coroutine.Task;

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
