document.addEventListener("DOMContentLoaded", function() {

	var submit = document.querySelector("form");
	var liStart = "<li>";
	var liEnd = "</li>";
	submit.addEventListener("submit", function() {
		
		while (true){
			var news = document.querySelector(".new");
			if (news.value.length == 0){
				break;
			}
		
		var newses = news.value.split("\n");
		news.value = null;
		for (var i = 0; i < newses.length; i++) {
			if (newses[i].indexOf("<li>") > -1) {
				news.value += newses[i] + "\n";

			} else {

				newses[i] = liStart + newses[i] + liEnd + "\n";
				news.value += newses[i];
			}
		}
		news.value = news.value.substring(0, news.value.length - 1);
		break;
		}
	});
});