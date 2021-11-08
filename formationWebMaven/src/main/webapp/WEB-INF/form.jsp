<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%
		if (request.getParameter("error") != null) {
		%>
		<div>prenom obligatoire</div>
		<%
		}
		%>
		<c:if test="${param.error != null }">
			<div>prenom obligatoire</div>
		</c:if>
		<c:choose>
			<c:when test="${param.error == 'login' }">erreur login</c:when>
			<c:when test="${param.error == 'password' }">erreur password</c:when>
			<c:otherwise>erreur </c:otherwise>
		</c:choose>
		<c:set var="var" value="toto"></c:set>
		<form action="bonjour" method="get">
			votre prenom:<input name="prenom">
			<button type="submit">envoyer</button>
		</form>
	</div>
</body>
</html>