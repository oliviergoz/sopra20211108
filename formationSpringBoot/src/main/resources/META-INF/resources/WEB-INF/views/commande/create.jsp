<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form action="save" method="post" modelAttribute="commande">
			<div class="form-group">
				<form:label path="date">date:</form:label>
				<form:input type="date" path="date" cssClass="form-control" />
				<form:errors path="date"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="client.id">client</form:label>
				<form:select path="client.id" cssClass="form-control">
					<form:options items="${clients}" itemLabel="infos" itemValue="id"/>
				</form:select>
				<form:errors path="client"></form:errors>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="../commande" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>