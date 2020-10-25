$(document).ready(function(e){
	libelle = $("#libelle");
	
	
	$("#form").submit(function(e){
		
		a = 0;
		
		if(libelle.val().trim()==""){
			$("#form").addClass("was-validated");
			a = 1;
		}
		
		return a == 0;
		
	});
	
});