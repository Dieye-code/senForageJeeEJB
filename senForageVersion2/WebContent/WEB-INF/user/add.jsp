<%@ include file="../../public/header.jsp"%>



<div class="card col-md-8 offset-md-2 mt-5">
	<div class="card-header bg-primary text-white text-center">Ajout
		d'un Utilisateur</div>
	<div class="card-body">


		<form class="form" method="POST"
			action='<c:out value="${baseUrl }User/add"/>' id="form"
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
				<div class="form-group col-md-6">
					<label class="control-label">Adresse</label> <input type="text"
						name="adresse" id="adresse" class="form-control" required />
				</div>
				<div class="form-group col-md-6">
					<label class="control-label">Email</label> <input type="email"
						name="email" id="email" class="form-control" required />
				</div>
			</div>

			<div class="form-group">
				<c:forEach items="${roles }" var="role">
					<%-- <input type="checkbox" class="custom-control-input" name="role[]">
					<label class="control-label"><c:out
							value="${role.libelle }" /></label> --%>

					<div class="form-check">
						<input type="checkbox" class="form-check-input" name="role[]" value='<c:out
								value="${role.id }" />'>
						<label class="form-check-label"><c:out
								value="${role.libelle }" /></label>
					</div>

				</c:forEach>
			</div>

			<div class="form-group">
				<input type="submit" name="ajouter" id="ajouter"
					class="btn btn-primary" value="Ajouter" />
			</div>

		</form>

	</div>
</div>


<script type="text/javascript"
	src='<c:out value="${base_url }public/js/jquery.js"/>'></script>
<script type="text/javascript"
	src='<c:out value="${base_url }public/js/bootstrap.js"/>'></script>
<script type="text/javascript"
	src='<c:out value="${base_url }page/filiere/filiere.js"/>'></script>


<%@ include file="../../public/footer.jsp"%>

