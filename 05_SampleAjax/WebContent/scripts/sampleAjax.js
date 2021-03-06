$(document).ready(function() {
	"use strict";
	// CRUD Create Read Update Delete List
	
	var ENDPOINT = "http://localhost:8080/05_SampleBackend/api/v1/tasks";
	
	function taskEndpoint(taskId) {
		return ENDPOINT + "/" + taskId;
	}

	// Error-handling
	$(document).ajaxError(function() {
		alert("Error " + arguments);
	});
	
	// list all tasks
	$.ajax(ENDPOINT, {
		method: "GET",
		// add parameters to URL
		data: {
			title: "hello"
		},
		dataType: "json"
	}).then(function(response) {
		console.log(response);
	});
	
	// read a single task
	$.ajax(taskEndpoint(2), {
		method: "GET",
		data: {
			title: "Hello"
		},
		dataType: "json"
	}).then(function(response) {
		console.log(response);
	});
	
	// add task
	var task = {
		title: "hello",
		description: "some text"
	};
	var newTaskId;
	var createPromise = $.ajax(ENDPOINT, {
		method: "POST",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(task),
		dataType: "json"
	}).then(function (response) {
		console.log(response);

		return response
	});

	// update task
	task.title = "Hello world";
	$.ajax(taskEndpoint(2), {
		method: "PUT",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify({
			title: "updated",
			description: "Sample description.. but updated"
		}),
		dataType: "json"
	}).then(function (response) {
		console.log(response);
	});
	
	// delete task
	createPromise.then(function(response) {
		// promise is being executed after create promise
		$.ajax(taskEndpoint(response.id), {
			method: "DELETE"
		});
	});
	
	/* 2 input fields (title, description)
	+ button 
	after button is pressed -> post*/ 
	
});