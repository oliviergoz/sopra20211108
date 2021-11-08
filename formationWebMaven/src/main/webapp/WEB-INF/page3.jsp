<%@page import="java.util.List"%>
<%@page import="servlet.Personne"%>
<%@page import="java.util.Arrays"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%
		List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
		%>
		<table>
			<%
			for (Personne p : personnes) {
			%>
			<tr>
				<td><%=p.getPrenom()%></td>
				<td><%=p.getNom()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<div>
		<table>
			<c:forEach items="${personnes}" var="p">
				<tr>
					<td>${p.prenom}</td>
					<td>${p.infos}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>