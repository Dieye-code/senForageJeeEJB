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
		<a href="<c:out value='${base_url }Village/add'/>"
			class="btn btn-primary">Ajouter</a>
	</div>
	<div class="card col-md-6 offset-md-3">
		<div class="card-header bg-primary text-white">Liste Des
			Villages</div>
		<div class="card-body">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Id</th>
					<th>Libelle</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${villages }" var="village">
					<tr>
						<td><c:out value="${village.id }" /></td>
						<td><c:out value="${village.libelle }" /></td>
						<td><a
							href="<c:out value='${base_url }Village/edit/${village.id }'/>">edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
