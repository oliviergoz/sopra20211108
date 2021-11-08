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
		<p>
			Bonjour
			<%=request.getParameter("username") != null ? request.getParameter("username") : ""%>
		</p>
		</p>
		Bonjour ${param.username} <a
			href="http://lien.fr?param=${param.username}">lien</a>
		</p>
		<p>
			Bonjour	<%=request.getParameter("username").toUpperCase() %>
		</p>
		
		<p>
			Bonjour	${param.username.toUpperCase() }
		</p>
	</div>
</body>
</html>