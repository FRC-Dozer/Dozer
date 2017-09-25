
package com.saintsrobotics.framework;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;

import com.saintsrobotics.framework.coroutine.Task;
import com.saintsrobotics.framework.coroutine.TaskRunner;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class TaskRobot extends IterativeRobot {
	
	protected Task[] autonomousTasks;
	protected Task[] teleopTasks;
	protected Task[] testTasks;
	protected Task[] disabledTasks;
    
    private TaskRunner runner;    
    
    @Override
    public void autonomousInit() {
    	if(this.runner != null) {
    		this.runner.disable();
    		this.runner = null;
    	}
    	if(this.autonomousTasks == null) {
    		DriverStation.reportWarning("AutonomousTasks has not been initalized!", false);
    		return;
    	}
    	runner = new TaskRunner(this.autonomousTasks);
    }
    
    @Override
    public void teleopInit() {
    	if(this.runner != null) {
    		this.runner.disable();
    		this.runner = null;
    	}
    	if(this.teleopTasks == null) {
    		DriverStation.reportWarning("AutonomousTasks has not been initalized!", false);
    		return;
    	}
    	runner = new TaskRunner(this.teleopTasks);
    }
    
    @Override
    public void testInit() {
    	if(this.runner != null) {
    		this.runner.disable();
    		this.runner = null;
    	}
    	if(this.testTasks == null) {
    		DriverStation.reportWarning("AutonomousTasks has not been initalized!", false);
    		return;
    	}
    	runner = new TaskRunner(this.testTasks);
    }
    
    @Override
    public void disabledInit() {
    	if(runner != null) {
    		this.runner.disable();
    		this.runner = null;
    	}
    	if(this.disabledTasks == null) {
    		DriverStation.reportWarning("AutonomousTasks has not been initalized!", false);
    		return;
    	}
    	this.runner = new TaskRunner(disabledTasks);
    }
    
    @Override
    public void robotPeriodic() {
    	if(runner != null) {
    		runner.run();
    	}
    }
}
