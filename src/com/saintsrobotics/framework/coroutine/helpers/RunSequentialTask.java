package com.saintsrobotics.framework.coroutine.helpers;

import com.saintsrobotics.framework.coroutine.Task;

		
public abstract class RunSequentialTask extends Task {
	public RunSequentialTask(String ...strings ){
		
}
  @Override
  protected void runTask() {
    while (true) {
      runSequentialy();
    }
  }

  /**
   * Runs this method in a while loop. Must wait inside.
   */
  protected abstract void runSequentialy();
}
