package com.github.dozer.coroutine.helpers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunContinuousTask;

public class RunParallelTask extends RunContinuousTask {
	
	private List<Task> tasks;

	public RunParallelTask(Task... tasks) {
			System.out.println("Parallel task constructor");
		   this.tasks = new LinkedList<>();
		   this.tasks.addAll(Arrays.asList(tasks));
	}		

  @Override
  protected boolean runContinuously() {
	  for (Iterator<Task> taskIterator = tasks.iterator(); taskIterator.hasNext();) {
		
	      Task task = taskIterator.next();
	      if (task.iterator == null) {
	        task.iterator = task.iterator();
	      }

	      if (task.waiter != null && task.waiter.getAsBoolean()) {
	        if (task.iterator.hasNext()) {
//		    	  System.out.println(task.toString() + " has next");
	          task.waiter = task.iterator.next();
	        } else {
//		    	  System.out.println(task.toString() + " removed");

	          taskIterator.remove();
	        }
	      }
	  }
	  return tasks.isEmpty();
  }
}

