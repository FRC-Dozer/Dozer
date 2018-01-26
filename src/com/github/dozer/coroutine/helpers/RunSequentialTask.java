package com.github.dozer.coroutine.helpers;

import com.github.dozer.coroutine.Task;

		
public class RunSequentialTask extends Task {
	private Task[] tasks;


	public RunSequentialTask(Task...tasks){
		this.tasks = tasks;
		
}
  @Override
  protected void runTask() {
	  for(Task t : this.tasks) {
		  t.iterator =  t.iterator();
		  while(t.iterator.hasNext()) {
			  yield(t.iterator.next());
		  }
	  }
  }
}
