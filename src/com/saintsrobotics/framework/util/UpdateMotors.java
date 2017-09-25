package com.saintsrobotics.framework.util;


import com.saintsrobotics.framework.coroutine.helpers.RunEachFrameTask;
import com.saintsrobotics.framework.output.Motors;

public class UpdateMotors extends RunEachFrameTask {
	private Motors motors;
	public UpdateMotors(Motors motors){
		this.motors = motors;
	}
	@Override
	protected void runEachFrame() {
		motors.update();
	}
}
