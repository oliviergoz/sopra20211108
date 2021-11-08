<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<c:if test="${auth}">
			<div class="alert alert-danger">informations incorrectes</div>
		</c:if>
		<c:if test="${isNull}">
			<div class="alert alert-danger">informations obligatoires</div>
		</c:if>
		<c:if test="${filter}">
			<div class="alert alert-danger">il faut d'abord etre
				authentifié</div>
		</c:if>
		<form action="${ctx}/login" method="post">
			<div class="form-group">
				<label>login:</label> <input name="login" class="form-control">
			</div>
			<div class="form-group">
				<label>mot de passe:</label> <input type="password" name="password"
					class="form-control">
			</div>
			<div class="form-group">
				<button type="submit" class="btn">envoyer</button>
				<a href="public/page1" class="btn btn-link">retour</a>
			</div>
		</form>
	</div>
</body>
</html>