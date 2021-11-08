<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<%!
	//attributs et methode de la classe
	private String texte="un texte";

	public String getTexte(){
		return texte;
	}
%>
<body>
	<%
	for (int i = 0; i < 5; i++) {
	%>
	<h1>hello <%=i %></h1>
	<input value="<%=i%>">
	<a href="http://unlien.fr?param=<%=i%>"><%=getTexte() %></a>
	<%
	}
	%>
	<%--commentaire jsp pas dans le rendu--%>
	<!-- commentaire html dans le rendu-->
</body>
</html>