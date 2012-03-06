$(document).load() {
	$("#word_button").click(function () {
		$.getJSON('/words', function(data) {
			  var items = [];

			  $.each(data, function(key, val) {
			    items.push(val);
			  });

			  (items.join(',')).appendTo('#words');
			});
	});
};