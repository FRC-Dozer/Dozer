
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
  /**
   * Initalizes the autonomous state by setting up the TaskRunner for the Robot during Autonomous.
   * autonmousTasks is expected to be defined in Robot.java and then this declared through super.
   * Without this declaration, the DriverStation will be warned when this init is called.
   * @method autonomousInit
   */
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

  /**
   * Initalizes the teleop state by setting up the TaskRunner for the Robot during telop.
   * teleopTasks is expected to be defined in Robot.java and then this declared through super.
   * Without this declaration, the DriverStation will be warned when this init is called.
   * @method teleopInit
   */
  @Override
  public void teleopInit() {
    if (this.runner != null) {
      this.runner.disable();
      this.runner = null;
    }
    if (this.teleopTasks == null) {
      DriverStation.reportWarning("teleopTasks has not been initalized!", false);
      return;
    }
    runner = new TaskRunner(this.teleopTasks);
  }

  /**
   * Initalizes the test state by setting up the TaskRunner for the Robot during testing.
   * testTasks is expected to be defined in Robot.java and then this declared through super.
   * Without this declaration, the DriverStation will be warned when this init is called.
   * @method testInit
   */
  @Override
  public void testInit() {
    if (this.runner != null) {
      this.runner.disable();
      this.runner = null;
    }
    if (this.testTasks == null) {
      DriverStation.reportWarning("testTasks has not been initalized!", false);
      return;
    }
    runner = new TaskRunner(this.testTasks);
  }

  /**
   * Initalizes the disabled state by setting up the TaskRunner for the Robot.
   * disabledTasks is expected to be defined in Robot.java and then this declared through super.
   * Without this declaration, the DriverStation will be warned when this init is called.
   * @method testInit
   */
  @Override
  public void disabledInit() {
    if (runner != null) {
      this.runner.disable();
      this.runner = null;
    }
    if (this.disabledTasks == null) {
      DriverStation.reportWarning("disabledTasks has not been initalized!", false);
      return;
    }
    this.runner = new TaskRunner(disabledTasks);
  }

  /**
   * Runs the robot peridodically as long as the runner exists and has been initalized by one of the init methods.
   * This should never be called outside of the init satement.
   * @method robotPeridoic
   */
  @Override
  public void robotPeriodic() {
    if (runner != null) {
      runner.run();
    }
  }
}
