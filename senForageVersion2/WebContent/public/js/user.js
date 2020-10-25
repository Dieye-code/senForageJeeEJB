$(document).ready(function() {

	email = $("#email");
	password = $("#password");


	email.blur(function() {

		a = /[a-zA-Z0-9]+[@][a-z]+[\.][a-z]{2,3}/

		if (!a.test(email.val())) {
			email.addClass("is-invalid");
			email.removeClass("is-valid");
		} else {
			email.removeClass("is-invalid");
			//email.css("border", "1px solid #ced4da");
		}

	});


	$("#login").submit(function(e) {
		a = 0;
		emailTest = /[a-zA-Z0-9]+[@][a-z]+[\.][a-z]{2,3}/;

		if (email.val().trim() == "" || password.val() == "") {
			$("#login").addClass("was-validated");
			a = 1;
		}

		if (!emailTest.test(email.val())) {
			email.addClass("is-invalid");
			email.removeClass("is-valid");
			a = 1;
		} else {
			email.removeClass("is-invalid"); 
		}

		return a1=1;
	});

});