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
		<h1>liste des commandes</h1>
		<table class="table">
			<thead>
				<tr>
					<th>numero:</th>
					<th>date:</th>
					<th>client:</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${commandes}" var="c">
					<tr>
						<td>${c.numero}</td>
						<td>${c.date}</td>
						<td>${c.client.prenom}&nbsp;${c.client.nom }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="commande/add" class="btn btn-link">nouvelle commande</a>
	</div>
</body>
</html>