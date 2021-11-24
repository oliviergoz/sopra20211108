<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<title>eshop</title>
</head>
<body>
	<div class="container">
		<h1>liste des produits</h1>
		<table class="table">
			<thead>
				<tr>
					<th>id:</th>
					<th>nom:</th>
					<th>description:</th>
					<th>prix</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produits}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.nom}</td>
						<td>${p.description}</td>
						<td>${p.prix}</td>
						<td><a href="produit/edit?id=${p.id}" class="btn btn-outline-primary">edition</a></td>
						<td><a href="produit/delete?id=${p.id}"
							class="btn btn-outline-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="produit/add" class="btn btn-link">nouveau produit</a>
	</div>
</body>
</html>