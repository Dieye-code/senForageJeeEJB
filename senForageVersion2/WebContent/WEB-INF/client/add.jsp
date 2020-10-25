<%@ include file="../../public/header.jsp"%>



<div class="card col-md-8 offset-md-2 mt-5">
	<div class="card-header bg-primary text-white text-center">Ajout
		d'un Client</div>
	<div class="card-body">

		<c:if test="${a!=null }"><div class="alert alert-danger">Echec de l'ajout du client</div></c:if>
		
		<form class="form" method="POST"
			action='<c:out value="${baseUrl }Client/add"/>' id="form"
			novalidate="novalidate">

			<div class="form-row">
				<div class="form-group col-md-5">
					<label class="control-label">Prenom</label> <input type="text"
						name="prenom" id="prenom" class="form-control" required />
				</div>
				<div class="form-group col-md-3">
					<label class="control-label">Nom</label> <input type="text"
						name="nom" id="nom" class="form-control" required />
				</div>
				<div class="form-group col-md-4">
					<label class="control-label">Date Naissance</label> <input
						type="date" name="dateNaissance" id="dateNaissance"
						class="form-control" required />
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-7">
					<label class="control-label">Lieu Naiissance</label> <input
						type="text" name="lieuNaissance" id="lieuNaissance"
						class="form-control" required />
				</div>
				<div class="form-group col-md-5">
					<label class="control-label">Telephone</label> <input type="text"
						name="telephone" id="telephone" class="form-control" required />
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-8">
					<label class="control-label">Adresse</label> <input type="text"
						name="adresse" id="adresse" class="form-control" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label">Village</label> <select
					class="form-control" name="village" id="village">
					<option value="">Selectionner le Village</option>
					<c:forEach items="${villages }" var="village">
						<option value='<c:out value="${village.id }"/>'><c:out value="${village.libelle }"/></option>
					</c:forEach>
				</select>
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

