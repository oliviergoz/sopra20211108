<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>edition</h1>
		<form action="save" method="post">
			<div class="form-group">
				<label>id:</label> <input name="id" class="form-control"
					readonly="readonly" value="${produit.id}">
			</div>
			<div class="form-group">
				<label>nom:</label> <input name="nom" class="form-control"
					value="${produit.nom}">
			</div>
			<div class="form-group">
				<label>description:</label>
				<textarea rows="15" cols="120" class="form-control"
					name="description">${produit.description}</textarea>
			</div>
			<div class="form-group">
				<label>prix:</label> <input type="number" name="prix"
					class="form-control" value="${produit.prix}" step="0.1">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="../" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>