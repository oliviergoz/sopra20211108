<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	variable session:${sessionScope['session1']}, ${session1}
	<br /> variable application:${applicationScope['application1']},
	${application1}

	<%
	Cookie tab[] = request.getCookies();
	if (tab != null) {
		for (Cookie c : tab) {
	%>
	<%=c.getName()%>
	<%=c.getValue()%>
	<%
	}
	}
	%>
	${start}
</body>
</html>