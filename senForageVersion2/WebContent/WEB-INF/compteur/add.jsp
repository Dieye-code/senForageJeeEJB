<%@ include file="../../public/header.jsp"%>



<div class="card col-md-8 offset-md-2 mt-5">
	<div class="card-header bg-primary text-white text-center">Ajout
		d'un Compteur Pour un Abonnement</div>
	<div class="card-body">

		<c:if test="${a!=null }">
			<div class="alert alert-danger">Echec de l'attribution du Compteur</div>
		</c:if>

		<form class="form" method="POST"
			action='<c:out value="${baseUrl }Compteur/add"/>' id="form"
			novalidate="novalidate">
			<div class="form-group">
				<label class="control-label">Date Attribution</label> <input
					type="date" name="dateAttribution" id="dateAttribution"
					class="form-control" required />
			</div>

			<div class="form-group">
				<label class="control-label">Abonnement</label> <select
					class="form-control" name="abonnement" id="abonnement">
					<option value="">Selectionner l'abonnement</option>
					<c:forEach items="${abonnements }" var="abonnement">
						<option value='<c:out value="${abonnement.id }"/>'><c:out
								value="${abonnement.id } ${abonnement.client.personne.prenom } ${abonnement.client.personne.nom }" /></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label class="control-label">Description de l'Attribution</label>
				<textarea rows="5" name="description" id="description" class="form-control"></textarea>
			</div>
			<div class="form-group">
				<input type="submit" name="ajouter" id="ajouter"
					class="btn btn-primary" value="Ajouter" />
			</div>

		</form>

	</div>
</div>


<script type="text/javascript"
	src='<c:out value="../public/js/jquery.js"/>'></script>
<script type="text/javascript"
	src='<c:out value="../public/js/bootstrap.js"/>'></script>
<script type="text/javascript"
	src='<c:out value="../public/js/client.js"/>'></script>


<%@ include file="../../public/footer.jsp"%>

