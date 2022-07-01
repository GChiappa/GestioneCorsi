<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Accesso negato</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h3>Non puoi più accedere a al sito</h3>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Sito non disponibile</h3>
			</div>
			<div class="panel-body">
				<p>Troppi tentativi di accesso.</p>
				<p>Riprova più tardi.</p>
			</div>
		</div>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>