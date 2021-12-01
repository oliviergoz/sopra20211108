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
		<jsp:include page="../logout.jsp"></jsp:include>
		<h1>mon panier</h1>
		<table class="table">
			<thead>
				<tr>
					<th>nom:</th>
					<th>prix</th>
					<th>quantite:</th>
					<th>total:</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="total" value="0"></c:set>
				<c:forEach items="${panier}" var="e">
					<tr>
						<td>${e.key.nom}</td>
						<td>${e.key.prix}</td>
						<td>${e.value}</td>
						<td>${e.value * e.key.prix}</td>
					</tr>
					<c:set var="total" value="${total + e.value * e.key.prix}"></c:set>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td>total panier:</td>
					<td>${total}</td>
				</tr>
			</tbody>
		</table>
		<a href="valider" class="btn btn-link">valider</a>
	</div>
</body>
</html>