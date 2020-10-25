<%@ include file="../../public/header.jsp"%>



<div class="card col-md-8 offset-md-2 mt-5">
	<div class="card-header bg-primary text-white text-center">Ajout
		d'un Utilisateur</div>
	<div class="card-body">

	<c:if test="${exist!=null })">
		<div class="alert alert-danger">Cet Village Existe dans la base de donnees</div>
	</c:if>

		<form class="form" method="POST"
			action='<c:out value="${baseUrl }Village/add"/>' id="form"
			novalidate="novalidate">
			<div class="form-group col-md-5">
				<label class="control-label">Libelle</label> <input type="text"
					name="libelle" id="libelle" class="form-control" required />
			</div>


			<div class="form-group">
				<input type="submit" name="ajouter" id="ajouter"
					class="btn btn-primary" value="Ajouter" />
			</div>

		</form>

	</div>
</div>


<script type="text/javascript"
	src='../public/js/jquery.js'></script>
<script type="text/javascript"
	src='../public/js/bootstrap.js'></script>
<script type="text/javascript"
	src='../public/js/village.js'></script>


<%@ include file="../../public/footer.jsp"%>

