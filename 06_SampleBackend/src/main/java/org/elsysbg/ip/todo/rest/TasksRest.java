package org.elsysbg.ip.todo.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.elsysbg.ip.todo.entities.Task;
import org.elsysbg.ip.todo.services.TaskService;

@Path("/tasks")
public class TasksRest {

	private final TaskService taskService;
	
	@Inject
	public TasksRest(TaskService task) {
		this.taskService = task;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Task> getTasks() {
		return taskService.getTasks();
	}

	@GET
	@Path("/{taskId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Task getTask(@PathParam("taskId") long taskId) {
		return taskService.getTask(taskId);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Task createTask(Task task) {
		return taskService.createTask(task);
	}
	
	@DELETE
	@Path("/{taskId}")
	public void deleteTask(@PathParam("taskId") long taskId) {
		taskService.deleteTask(taskId);
	}
	
	@PUT
	@Path("/{taskId}")
	public Task updateTask(@PathParam("taskId") long taskId, Task task) {
		final Task fromDb = taskService.getTask(taskId);
		fromDb.setTitle(task.getTitle());
		fromDb.setDescription(task.getDescription());
		return taskService.updateTask(fromDb);
	}
	
}
