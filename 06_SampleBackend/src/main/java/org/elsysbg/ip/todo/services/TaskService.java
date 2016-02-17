package org.elsysbg.ip.todo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Singleton;

import org.elsysbg.ip.todo.entities.Task;

@Singleton
public class TaskService {
	
	// Synchronized list, bearing in mind that the webapp would be accessed
	// from many clients	
	private List<Task> tasks = Collections.synchronizedList(
			new LinkedList<Task>());
	
	private long lastId = 0;
	
	private synchronized long getAndIncrementNextId() {
		return ++lastId;	
	}
	
	public Task createTask(Task task) {
		task.setId(getAndIncrementNextId());
		tasks.add(task);
		return task;
	}
	
	public List<Task> getTasks() {
		return new ArrayList<Task>(tasks);
	}
	
	public Task getTask(long taskID) {
		for (Task task : tasks) {
			if (taskID == task.getId()) {
				return task;
			}
		} 
		throw new IllegalArgumentException("No task with id " + taskID);
	}
	
	public Task updateTask(Task task) {
		deleteTask(task.getId());
		tasks.add(task);
		return task;
	}
	
	public void deleteTask(long taskId) {
		final Task oldTask = getTask(taskId);
		tasks.remove(oldTask);
	}
	
}
