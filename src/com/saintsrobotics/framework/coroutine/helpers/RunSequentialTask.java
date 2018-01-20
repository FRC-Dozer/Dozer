package com.saintsrobotics.framework.coroutine.helpers;

import com.saintsrobotics.framework.coroutine.Task;

		
public abstract class RunSequentialTask extends Task {
	public RunSequentialTask(Task...tasks ){
		int tasksLength = tasks.length;
		
}
  @Override
  protected void runTask() {
    while (true) {
      runSequentialy();
      int tasksLength = tasks.length;
      for(int TasksRun = 0;TasksRun<tasksLength;TasksRun++) {
			
		}
    }
  }

  /**
   * Runs this method in a while loop. Must wait inside.
   */
  protected abstract void runSequentialy();
}
