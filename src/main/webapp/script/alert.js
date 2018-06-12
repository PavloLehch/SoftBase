document.addEventListener("DOMContentLoaded", function() {

	var look = document.querySelector("h2");
		if (look.className !== ""){
			alert("You don't delete this: some programs have it!!!");
			location.href = "../"+look.className;
		}
	
});