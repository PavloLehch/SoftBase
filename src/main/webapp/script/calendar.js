document.addEventListener("DOMContentLoaded", function() {

	// select radiobutton
	var radios = document.querySelectorAll("input[type='radio']");
	var find = document.getElementById("find");
	var submit = document.querySelector("form");

	submit.addEventListener("submit", function(event) {
		for (var i = 0; i < radios.length; i++) {
			if (radios[i].checked == true) {
				break;
			} else if (radios[i].checked == false) {
				if (i == radios.length - 1) {
					alert("Please choose search option");
					event.preventDefault();
				}
			}

		}

	});

	// change string to date, if choosen 'add date' search
	for (var i = 0; i < radios.length; i++) {
		radios[i].addEventListener("click", function() {
			if (this.value === "date") {
				find.type = "date";
			} else if (this.value !== "date") {
				find.type = "text";
			}
		});
	}

});