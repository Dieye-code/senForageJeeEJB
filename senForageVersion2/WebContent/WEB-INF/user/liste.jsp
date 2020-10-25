<%@ include file="../../public/header.jsp"%>


<c:if test="${a!= null }">
	<script type="text/javascript" src="${base_url }public/js/jquery.js"></script>
	<script type="text/javascript" src="${base_url }public/js/notyf.min.js"></script>
	<script type="text/javascript">
		var t = new Notyf({
            duration : 2000 , 
            position : { 
                x : 'right' , 
                y : 'top' , 
            }
        })
        t.success("Utilisateur Bien Ajoute");
        setTimeout(()=>{
            t.dismissAll();
        },2000);
		</script>
</c:if>
<c:if test="${b!= null }">
	<script type="text/javascript" src="${base_url }public/js/jquery.js"></script>
	<script type="text/javascript" src="${base_url }public/js/notyf.min.js"></script>
	<script type="text/javascript">
		var t = new Notyf({
            duration : 2000 , 
            position : { 
                x : 'right' , 
                y : 'top' , 
            }
        })
        t.success("Utilisateur Bien Modifie");
        setTimeout(()=>{
            t.dismissAll();
        },2000);
		</script>
</c:if>

<div class="mt-5">
	<div>
		<a href="<c:out value='${base_url }User/add'/>"
			class="btn btn-primary">Ajouter</a>
	</div>
	<div class="card">
		<div class="card-header bg-primary text-white">Liste Des
			Etudiants</div>
		<div class="card-body">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Date Naissance</th>
					<th>Lieu Naissance</th>
					<th>Telephone</th>
					<th>Adresse</th>
					<th>Email</th>
					<th>Role</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${users }" var="user">
					<tr>
						<td><c:out value="${user.personne.nom }" /></td>
						<td><c:out value="${user.personne.prenom }" /></td>
						<td><c:out value="${user.personne.dateNaissance }" /></td>
						<td><c:out value="${user.personne.lieuNaissance }" /></td>
						<td><c:out value="${user.personne.telephone }" /></td>
						<td><c:out value="${user.personne.adresse }" /></td>
						<td><c:out value="${user.email }" /></td>
						<td>
						
							<c:forEach items="${user.roles }" var="role">
								<c:out value="${role.libelle }" />
							</c:forEach>
						
						</td>
						<td><a
							href="<c:out value='${base_url }Etudiant/edit/${user.id }'/>">edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
