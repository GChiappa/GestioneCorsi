<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Errore 404</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-danger" style="text-align: center;">
			<div class="panel-heading">
				<h5 class="card-title">Pagina non trovata</h5>
			</div>
			<div class="panel-body">
				<h6 class="card-subtitle mb-2 text-muted">Errore 404</h6>
				<a href="home.jsp"><button class="btn btn-outline-dark">Torna
						alla home</button></a>
				<button onclick="window.history.back()" class="btn btn-secondary">Indietro</button>
			</div>
		</div>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>