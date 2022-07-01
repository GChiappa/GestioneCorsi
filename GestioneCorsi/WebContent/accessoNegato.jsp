
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
<title>Accesso negato</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h3>Non puoi accedere a questa pagina</h3>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Risorsa non disponibile</h3>
			</div>
			<div class="panel-body">
				<p>Per accedere alla pagina:</p>
				<p>Effettuare il login</p>
				<p>
					<a href="index.jsp">Login</a>
				</p>

			</div>
		</div>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>