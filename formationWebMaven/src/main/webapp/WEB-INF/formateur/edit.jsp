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
<title>edition formateur</title>
</head>
<body>
	<div class="container">
		<h1>edition formateur</h1>
		<div>
			<form action="formateur" method="post">
				<input type="hidden" name="q" value="save">
				<div class="form-group">
					<label>id:<input class="form-control" name="id" readonly="readonly" value="${formateur.id}"></label>
				</div>
				<div class="form-group">
					<label>prenom:<input class="form-control" name="prenom" value="${formateur.prenom}"></label>
				</div>
				<div class="form-group">
					<label>nom:<input class="form-control" name="nom" value="${formateur.nom}"></label>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-outline-primary">enregistrer</button>
					<a href="formateur" class="btn btn-outline-warning">annuler</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>