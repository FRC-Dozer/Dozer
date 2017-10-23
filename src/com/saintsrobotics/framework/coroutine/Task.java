package com.saintsrobotics.framework.coroutine;


import com.zoominfo.util.yieldreturn.Generator;
import edu.wpi.first.wpilibj.DriverStation;
import java.util.Iterator;
import java.util.function.BooleanSupplier;
/**
 * Abstract class for each Task. Allows you to run the task and use waiters in said task
 *
 * @class Task
 */
public abstract class Task extends Generator<BooleanSupplier> {

  protected Waiters wait = new Waiters();

  BooleanSupplier waiter = () -> true;
  Iterator<BooleanSupplier> iterator;

  @Override
  /**
   * Try/catch wrap for the absract method runTask. Ensures error repporting
   * @method run
   */
  protected void run() {
    try {
      runTask();
    } catch (Throwable t) {
      DriverStation.reportError("TASK CRASHED: " + this.getClass().getName() + " \n" + t.toString(),
          true);
      wait.forFrame();
    }
  }

  /**
   * Abstract method, runs when the task is run.
   * @method runTask
   */
  protected abstract void runTask();

  /**
   * Agregation of methods for waiting
   * @class Waiters
   */
  protected class Waiters {

    public void forFrame() {
      yield(() -> true);
    }

    /**
     * Waits for the given amount of seconds
     * @method forSeconds
     * @param  double     secs amount of seconds to wait
     */
    public void forSeconds(double secs) {
      long finalTimeMillis = (long) (secs * 1000) + System.currentTimeMillis();
      yield(() -> finalTimeMillis < System.currentTimeMillis());
    }

  /**
   * Waits until a condition is met
   * @method until
   * @param  BooleanSupplier predicate the condition to be met
   */
    public void until(BooleanSupplier predicate) {
      yield(predicate);
    }
  /**
   * Waits until a Condition is met or time is reached
   * @method untilWithTimeout
   * @param  BooleanSupplier  predicate condition
   * @param  double           secs      time in seconds
   */
    public void untilWithTimeout(BooleanSupplier predicate, double secs) {
      long finalTimeMillis = (long) (secs * 1000) + System.currentTimeMillis();
      yield(() -> predicate.getAsBoolean() || finalTimeMillis < System.currentTimeMillis());
    }
  }
}
