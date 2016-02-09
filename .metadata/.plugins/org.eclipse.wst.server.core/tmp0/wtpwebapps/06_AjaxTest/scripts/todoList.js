$(document).ready(function() {
	"use strict";
	
	var ENDPOINT = "http://localhost:3000/pois";
	
	function getSingleTask(val) {
		return $.ajax(ENDPOINT, {
			data: {
				type: val	
			},
			method: "GET",
			dataType: "json"
		}).then(function(response){
			var table = $("#result");
			$.each(response, function(i, data) {
				table.append("<tr><td>" + data.type +"</td><td>" + data.name + "</td></tr>");
			});
		});
	}
	
	$("#search").on("click", function() {
		var fieldVal = $("#filter").val();
		getSingleTask(fieldVal);
	});
	
});