$(document).ready(function() {
	$.ajax({
	    type: "GET",
	    url: basePath+htmlUrl,
	    contentType: 'text/plain',
	    success: function(result) {
		   $("#htmlUrl").append(result)
	   }
	})
});
