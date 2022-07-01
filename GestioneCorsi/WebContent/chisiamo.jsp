
<%
if (session.getAttribute("tentativi") != null && (int) session.getAttribute("tentativi") >= 5) {
	response.sendRedirect("troppitentativi.jsp");
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
	<div class="nav"><%@include file="nav.jsp"%></div>
	<div class="container">
		<div class="riguardonoi"><%@include file="riguardonoi.html"%></div>
	</div>
	<footer><%@include file="footer.html"%></footer>
</body>
</html>