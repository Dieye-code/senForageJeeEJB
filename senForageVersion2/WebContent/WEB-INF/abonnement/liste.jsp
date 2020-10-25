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
        t.success("Abonnement Bien Ajoute");
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
        t.success("Abonnement Bien Modifie");
        setTimeout(()=>{
            t.dismissAll();
        },2000);
		</script>
</c:if>

<div class="mt-5">
	<div>
		<a href="<c:out value='${base_url }Abonnement/add'/>"
			class="btn btn-primary">Ajouter</a>
	</div>
	<div class="card">
		<div class="card-header bg-primary text-white">Liste Des
			Abonnements</div>
		<div class="card-body">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Id</th>
					<th>Client</th>
					<th>Date Abonnement</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${abonnements }" var="abonnement">
					<tr>
						<td><c:out value="${abonnement.id}" /></td>
						<td><c:out value="${abonnement.client.personne.nom } ${abonnement.client.personne.nom }" /></td>
						<td><c:out value="${abonnement.dateAbonnement}" /></td>
						<td><a
							href="<c:out value='${base_url }Abonnement/edit/${abonnement.id }'/>">edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
