package com.saintsrobotics.framework.coroutine;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class TaskRunner {

  private List<Task> tasks;
  private boolean disabled = false;

  /**
   * Constructs TaskRunner with a list of tasks
   * @method TaskRunner
   * @param  Task...    tasks         the tasks that will be run by this taskrunner.
   *
   */
  public TaskRunner(Task... tasks) {
    this.tasks = new LinkedList<>();
    this.tasks.addAll(Arrays.asList(tasks));
  }

  /**
   * Controls how tasks run and makes sure no null or disabled tasks are run.
   * @method run
   */
  public void run() {
    if (disabled) {
      return;
    }

    for (Iterator<Task> taskIterator = tasks.iterator(); taskIterator.hasNext();) {
      Task task = taskIterator.next();
      if (task.iterator == null) {
        task.iterator = task.iterator();
      }

      if (task.waiter != null && task.waiter.getAsBoolean()) {
        if (task.iterator.hasNext()) {
          task.waiter = task.iterator.next();
        } else {
          taskIterator.remove();
        }
      }
    }
  }

  /**
   * Sets the task runner to disabled so it will not be run
   * @method disable
   */
  public void disable() {
    this.disabled = true;
  }
}
