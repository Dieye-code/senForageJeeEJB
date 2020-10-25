<%@ include file="../../public/header.jsp"%>


<c:choose>

	<c:when test="${abonnement !=null }">

		<div class="card col-md-8 offset-md-2 mt-5">
			<div class="card-header bg-primary text-white text-center">Modification
				d'un Abonnement</div>
			<div class="card-body">

				<c:if test="${a!=null }">
					<div class="alert alert-danger">Echec de la modification de
						l'abonnement</div>
				</c:if>

				<form class="form" method="POST"
					action='<c:out value="${baseUrl }Abonnement/edit/${abonnement.id }"/>' id="form"
					novalidate="novalidate">
					<div class="form-group">
						<label class="control-label">Date Abonnement</label> <input
							type="date" name="dateAbonnement" id="dateAbonnement"
							class="form-control" value='<c:out value="${abonnement.dateAbonnement }"/>' required />
					</div>

					<div class="form-group">
						<label class="control-label">Client</label> <select
							class="form-control" name="client" id="client">
							<option value="">Selectionner le client</option>
							<c:forEach items="${clients }" var="client">
								<option value='<c:out value="${client.id }"/>' <c:if test="${abonnement.client.id==abonnement.id }">selected</c:if> ><c:out
										value="${client.personne.prenom } ${client.personne.nom }" /></option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label class="control-label">Description de l'Abonnement</label>
						<textarea rows="5" name="description" id="description"
							class="form-control"><c:out value="${abonnement.description }"/></textarea>
					</div>
					<div class="form-group">
						<input type="submit" name="modifier" id="ajouter"
							class="btn btn-primary" value="Modifier" />
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

	</c:when>
	<c:when test="${client==null }">
		<div class="alert alert-danger">Le Client n'existe pas dans la
			base de données</div>
	</c:when>

</c:choose>





<%@ include file="../../public/footer.jsp"%>

