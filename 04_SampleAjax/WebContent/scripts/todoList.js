$(document).ready(function() {
	"use strict";
	
	// class hand-written
	function written() {
		$(".submit").on("click", function() {
			var ENDPOINT = "http://localhost:3000/tasks";
			var title = $(".title").val();
			var descr = $(".description").val();
			
			var task = {
				title: title,
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
	
	var ENDPOINT = "http://localhost:3000/tasks";
	
	
	function showTaskView(task) {
		$("#readPanel .task-title").text(task.title);
		$("#readPanel .task-description").text(task.description);
		showPanel("readPanel")
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
		$(".task-action-cancel").click(function() {
			showPanel("emptyPanel");
		});
	}
	
	attachHandlers();
	reloadTasks();
	
});