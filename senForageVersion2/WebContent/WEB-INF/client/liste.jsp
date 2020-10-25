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
        t.success("Client Bien Ajoute");
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
        t.success("Client Bien Modifie");
        setTimeout(()=>{
            t.dismissAll();
        },2000);
		</script>
</c:if>

<div class="mt-5">
	<div>
		<a href="<c:out value='${base_url }Client/add'/>"
			class="btn btn-primary">Ajouter</a>
	</div>
	<div class="card">
		<div class="card-header bg-primary text-white">Liste Des
			Clients</div>
		<div class="card-body">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Date Naissance</th>
					<th>Lieu Naissance</th>
					<th>Telephone</th>
					<th>Adresse</th>
					<th>Village</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${clients }" var="client">
					<tr>
						<td><c:out value="${client.personne.nom }" /></td>
						<td><c:out value="${client.personne.prenom }" /></td>
						<td><c:out value="${client.personne.dateNaissance }" /></td>
						<td><c:out value="${client.personne.lieuNaissance }" /></td>
						<td><c:out value="${client.personne.telephone }" /></td>
						<td><c:out value="${client.personne.adresse }" /></td>
						<td><c:out value="${client.village.libelle }" /></td>
						<td><a
							href="<c:out value='${base_url }Client/edit/${client.id }'/>">edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
