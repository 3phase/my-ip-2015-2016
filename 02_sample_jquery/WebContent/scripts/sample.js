$(document).ready(function() {
	"use strict" 		// latest version, strict mode, i.e. predefined variables are required

	function removeByClassName() {
		$(".name-column").remove();
	}
	
	function removeById() {
		$("#haha").remove();
	}
	
	function removeByType() {
		$("td").remove();
	}
	
	function removeByDescendant() {
		$("ul li").remove();
	}
	
	function removeByFound(parent) {
		parent.find("li").remove();
	}
	
//	removeByClassName();
//	removeById();
//	removeByType();
//	removeByDescendant();
//	removeByFound($("ol"));
	
	$("#removeMountain").on("mousemove", function() {
		console.log("mouse moved " + arguments); 
	});
	
	$("#removeMountain").click(function() {
		$("ol li:first").remove();
	});
	
	$("#createMountain").click(function() {
		var newMountainElement = $("</li>");
		var newMountainName = $(".name-of-new-mountain").val();
		$("#mountainNameInput").val("");
		newMountainElement.text(newMountainName);
		newMountainElement.attr("id", "mountain" + (nextFreeMountainId++));
		$("ol").append(newMountainElement);
	});
	
	$(document).on("click", "ul li", function() {
		alert($(this).attr("id"));
	});
	
	$("#hiking").click(function() {
		var allMountains = $("ul li");
//		jquery iteration
//		$.each(allMountains, function(index, value) {
//			var next = $(value);
//			alert(next.text());
//		});
		
		
//		lodash iterate
		_.forEach(allMountains, function(value) {
			var next = $(value);
			alert(next.text());
		});
		
//		C-like iteration way
//		for (var i = 0; i < allMountains.length; i++) {
//			var next = $(allMountains[i]);
//			alert(next.text());
//		}
	});
	
	
	$("table").append("<tr><td>4</td><td>Goshko bate</td></tr>")
	
	
});