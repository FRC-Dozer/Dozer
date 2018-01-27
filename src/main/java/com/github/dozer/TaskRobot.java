
package com.github.dozer;


import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.TaskRunner;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;

public abstract class TaskRobot extends IterativeRobot {

  protected Task[] autonomousTasks;
  protected Task[] teleopTasks;
  protected Task[] testTasks;
  protected Task[] disabledTasks;

  private TaskRunner runner;

  @Override
  public void autonomousInit() {
    if (this.runner != null) {
      this.runner.disable();
      this.runner = null;
    }
    if (this.autonomousTasks == null) {
      DriverStation.reportWarning("AutonomousTasks has not been initalized!", false);
      return;
    }
    runner = new TaskRunner(this.autonomousTasks);
  }

  @Override
  public void teleopInit() {
    if (this.runner != null) {
      this.runner.disable();
      this.runner = null;
    }
    if (this.teleopTasks == null) {
      DriverStation.reportWarning("AutonomousTasks has not been initalized!", false);
      return;
    }
    runner = new TaskRunner(this.teleopTasks);
  }

  @Override
  public void testInit() {
    if (this.runner != null) {
      this.runner.disable();
      this.runner = null;
    }
    if (this.testTasks == null) {
      DriverStation.reportWarning("AutonomousTasks has not been initalized!", false);
      return;
    }
    runner = new TaskRunner(this.testTasks);
  }

  @Override
  public void disabledInit() {
    if (runner != null) {
      this.runner.disable();
      this.runner = null;
    }
    if (this.disabledTasks == null) {
      DriverStation.reportWarning("AutonomousTasks has not been initalized!", false);
      return;
    }
    this.runner = new TaskRunner(disabledTasks);
  }

  @Override
  public void robotPeriodic() {
    if (runner != null) {
      runner.run();
    }
  }
}
