<%@ include file="../../public/header.jsp"%>


<c:if test="${vide!=null }">
	<div class="alert alert-danger">Email ou Password Incorrecte   ${password } </div>
</c:if>

<div id="login">
	<h3 class="text-center text-white pt-5">Login form</h3>
	<div class="container">
		<div id="login-row"
			class="row justify-content-center align-items-center">
			<div id="login-column" class="col-md-6">
				<div id="login-box" class="col-md-12">
					<form id="login-form login" class="form" action='<c:out value="${baseUrl }Login"/>' method="post" novalidate="novalidate">
						<h3 class="text-center text-info">Login</h3>
						<div class="form-group">
							<label for="username" class="text-info">Email:</label><br> <input
								type="text" name="email" id="email" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="password" class="text-info">Password:</label><br>
							<input type="password" name="password" id="password"
								class="form-control" required>
						</div>
						<div class="form-group">
							<input type="submit" name="authentifier"
								class="btn btn-primary btn-md" value="Authentifier">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src='<c:out value="${base_url }public/js/jquery.js"/>'></script>
<script type="text/javascript"
	src='<c:out value="${base_url }public/js/bootstrap.js"/>'></script>
<script type="text/javascript"
	src='<c:out value="${base_url }public/js/user.js"/>'></script>

<%@ include file="../../public/footer.jsp"%>

