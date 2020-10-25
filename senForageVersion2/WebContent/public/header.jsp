<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<title><c:out value="${title!= null ? title : 'Sene Forage' }" /></title>
<link rel="stylesheet" type="text/css"
	href='<c:out value="${baseUrl }public/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:out value="${baseUrl }public/css/notyf.min.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:out value="${baseUrl }public/css/styles.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:out value="${baseUrl }public/css/file.css"/>'>
</head>
<body class="d-flex flex-column h-100">
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<a class="navbar-brand" href="/senForageFirst/">Sen Forage</a>
		<button class="btn btn-link btn-sm order-1 order-lg-0"
			id="sidebarToggle">
			<i class="fas fa-bars"></i>
		</button>
	</nav>
			<nav class=""
				id="">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<c:if test="${sessionScope.administrateur!=null }">
							<a class="nav-link" href="/senForageVersion2/User"> User </a>
						</c:if>
						<c:if test="${sessionScope.gestionClientel!=null }">
							<a class="nav-link" href="/senForageVersion2/Village"> Village </a>
						</c:if>
						<c:if test="${sessionScope.gestionClientel!=null }">
							<a class="nav-link" href="/senForageVersion2/Client"> Client </a>
						</c:if>
						<c:if test="${sessionScope.gestionClientel!=null }">
							<a class="nav-link" href="/senForageVersion2/Abonnement"> Abonnement</a>
						</c:if>
						<c:if test="${sessionScope.gestionCompteur!=null }">
							<a class="nav-link" href="/senForageVersion2/Compteur"> Compteur</a>
						</c:if>
						<c:if test="${sessionScope.gestionCommercial!=null }">
							<a class="nav-link" href="/senForageVersion2/Facture"> Facture </a>
						</c:if>
						
					</div>
				</div>
			</nav>
	<div class="container">