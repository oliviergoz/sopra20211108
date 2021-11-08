<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formateur</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>liste des formateurs</h1>
		<table class="table">
			<thead>
				<th>id</th>
				<th>prenom</th>
				<th>nom</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${formateurs}" var="formateur">
					<tr>
						<td>${formateur.id}</td>
						<td>${formateur.prenom}</td>
						<td>${formateur.nom}</td>
						<td><a href="formateur?q=edit&id=${formateur.id}" class="btn btn-outline-primary">editer</a></td>
						<td><a href="formateur?q=delete&id=${formateur.id}"
							class="btn btn-outline-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="formateur?q=add" class="btn btn-link">nouveau formateur</a>
	</div>
</body>
</html>