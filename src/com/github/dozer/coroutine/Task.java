package com.github.dozer.coroutine;


import com.zoominfo.util.yieldreturn.Generator;
import edu.wpi.first.wpilibj.DriverStation;
import java.util.Iterator;
import java.util.function.BooleanSupplier;

public abstract class Task extends Generator<BooleanSupplier> {

  protected Waiters wait = new Waiters();

  public BooleanSupplier waiter = () -> true;
  public Iterator<BooleanSupplier> iterator;

  @Override
  protected void run() {
    try {
      runTask();
    } catch (Throwable t) {
      DriverStation.reportError("TASK CRASHED: " + this.getClass().getName() + " \n" + t.toString(),
          true);
      wait.forFrame();
    }
  }

  protected abstract void runTask();

  protected class Waiters {

    public void forFrame() {
      yield(() -> true);
    }

    public void forSeconds(double secs) {
      long finalTimeMillis = (long) (secs * 1000) + System.currentTimeMillis();
      yield(() -> finalTimeMillis < System.currentTimeMillis());
    }

    public void until(BooleanSupplier predicate) {
      yield(predicate);
    }

    public void untilWithTimeout(BooleanSupplier predicate, double secs) {
      long finalTimeMillis = (long) (secs * 1000) + System.currentTimeMillis();
      yield(() -> predicate.getAsBoolean() || finalTimeMillis < System.currentTimeMillis());
    }
  }
}
