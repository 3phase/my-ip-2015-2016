$(document).ready(function() {
	"use strict";
	
	// class hand-written
	function written() {
		$(".submit").on("click", function() {
			var ENDPOINT = "http://localhost:8080/05_SampleBackend/api/v1/tasks";
			var title = $(".title").val();
			var username = $(".username").val()
			var descr = $(".description").val();
			
			var task = {
				title: title,
				username: username,
				description: descr
			};
			
			$.ajax(ENDPOINT, {
				method: "POST",
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify(task),
				dataType: "json"
			}).then(function(response){
				console.log(response);
				return response
			});
		});
	}
	// end 
	
	var ENDPOINT = "http://localhost:8080/05_SampleBackend/api/v1/tasks";
	
	function updateTask(taskId, task) {
		$.ajax(ENDPOINT + "/" + taskId, {
			method: "PUT",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				title: task.title,
				description: task.description
			}),
			dataType: "json"
		}).then(function (response) {
			reloadTasks();
		});
	}
	
	function addTask(task) {
		var newTaskId;
		var createPromise = $.ajax(ENDPOINT, {
			method: "POST",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(task),
			dataType: "json"
		}).then(function (response) {
			console.log(response);
			reloadTasks();
			return response
		});
	}
	
	function deleteTask(taskId) {
		$.ajax(ENDPOINT + "/" + taskId, {
			method: "DELETE"
		}).then(function(response) {
			showPanel("emptyPanel");
			reloadTasks();
		});
	}
	
	function showTaskView(task) {
		$("#readPanel .task-title").text(task.title);
		$("#readPanel .task-username").text(task.username);
		$("#readPanel .task-description").text(task.description);
		showPanel("readPanel");
		$("#readPanel").attr("data-task-id", task.id);
	}
	
	function getSingleTask(id) {
		return $.ajax(ENDPOINT + "/" + id, {
			method: "GET",
			dataType: "json"
		});
	}
	
	function getAllTasks() {
		return $.ajax(ENDPOINT, {
			method: "GET",
			dataType: "json"
		})
	}
	
	function showPanel(panelName) {
		var ALL_PANELS = ["emptyPanel", "readPanel", "updatePanel", "createPanel"];
		_.forEach(ALL_PANELS, function(nextValue) {
				$("#" + nextValue).hide();
		});
		$("#" + panelName).show();
	}
	
	function reloadTasks() {
		getAllTasks().then(function(response) {
			function addTaskToList(task) {
				var newItem = $("<li />");
				newItem.text(task.title);
				newItem.addClass("list-group-item");
				newItem.attr("data-task-id", task.id);
				$("#tasksList").append(newItem);
			}
			
			$("#tasksList").html("");
			_.forEach(response, addTaskToList);
			
		});
	}
	
	function attachHandlers() {
		$(document).on("click", "#tasksList [data-task-id]", function() {
			var taskId = $(this).attr("data-task-id");
			
			getSingleTask(taskId).then(showTaskView);	// showTaskView -> receiving one arg from then
			
		});
		$("#createPanel button.btn.task-action-ok").click(function() {
			var task = {
				title: $("#createPanel input[name='title']").val(),
				username: $("#createPanel input[name='username']").val(),
				description: $("#createPanel textarea[name='description']").val()
			};
			addTask(task);
		});
		$(".task-action-cancel").click(function() {
			showPanel("emptyPanel");
		});
		$("#addTaskButton").click(function() {
			showPanel("createPanel");
		});
		$("#readPanel .task-action-ok").click(function() {
			var taskId = $("#readPanel").attr("data-task-id");
			var panelCts = {
				title: $(".form-group .task-title").html(),
				username: $(".form-group .task-username").html(),
				description: $(".form-group .task-description").html()
			};
			showPanel("updatePanel");
			$("#updatePanel").attr("data-task-id", taskId);
			$("#updatePanel input.form-control[name='title']").attr("value", panelCts.title);
			$("#updatePanel input.form-control[name='username']").attr("value", panelCts.username);
			$("#updatePanel textarea.form-control[name='description']").val(panelCts.description);
			
			$("#updatePanel .task-action-ok").click(function() {
				var updatedTask = {
					title: $("#updatePanel input.form-control").val(),
					username: $("#updatePanel input.form-control").val(),
					description: $("#updatePanel textarea.form-control").val()	
				};
				updateTask(taskId, updatedTask);
			});
		});
		$(".task-action-remove").click(function() {
			deleteTask($("#readPanel").attr("data-task-id"));
		});
	}
	
	attachHandlers();
	reloadTasks();
	
});