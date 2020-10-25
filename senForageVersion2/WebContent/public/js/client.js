$(document).ready(function() {

	nom = $("#nom");
	prenom = $("#prenom");
	dateNaissance = $("#dateNaissance");
	lieuNaissance = $("#lieuNaissance");
	telephone = $("#telephone");
	adresse = $("#adresse");
	village = $("#village");
	
	$("#form").submit(function(e){
	
		a = 0;
		if(nom.val().trim()=="" || prenom.val().trim()=="" || dateNaissance.val()=="" || lieuNaissance.val().trim()=="" || telephone.val().trim()=="" || adresse.val().trim()=="" || village.val()==""){
		
			$("#form").addClass("was-validated");
			a = 1;
		
		}
		
		if(village.val()=="" || village.val()=="0"){
		
			village.addClass("is-invalid");
			village.removeClass("is-valid");
			a=1;
		} else {
			village.addClass("is-valid");
			village.removeClass("is-invalid");
		
		}
	
		return a == 0;
	
	});
	
	
});