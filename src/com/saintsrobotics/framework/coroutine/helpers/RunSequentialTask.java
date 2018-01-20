package com.saintsrobotics.framework.coroutine.helpers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.saintsrobotics.framework.coroutine.Task;
import com.sun.jmx.snmp.tasks.TaskServer;

		
public abstract class RunSequentialTask extends Task {
	private List<Task> tasks;


	public RunSequentialTask(Task...tasks){
		this.tasks = new LinkedList<>();
	    this.tasks.addAll(Arrays.asList(tasks));
		
}
  @Override
  protected void runTask() {
	  for(Task t : this.tasks) {
		  while(t.iterator().hasNext()) {
			  yield(t.iterator().next());
		  }
	  }
  }
}
