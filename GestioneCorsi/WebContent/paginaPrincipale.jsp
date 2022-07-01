
<%
if (session.getAttribute("admin") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
	<div class="nav"><%@include file="nav.jsp"%></div>

	<div class="container">
		<div class="row">
			<h1 style="text-align: center">Management Alfacom</h1>
		</div>
		<div class="row" style="margin-top: 50px">
			<div class="col-sm-2 col-md-4"></div>

			<div class="col-xs-12 col-sm-8 col-md-4"
				style="width: 100%; text-align: center;">
				<a href="#">
				<button type="button" class="btn btn-default btn-lg btn-block"
					style="margin-top: 20px; height: 60px;">Inserisci nuovo Corsista</button>
				</a>
				<a href="gestioneCorsisti.jsp">	
				<button type="button" class="btn btn-default btn-block"
					style="margin-top: -8px; height: 30px;">Gestione Corsisti</button>
				</a>
				<a href="statistiche.jsp">		
				<button type="button" class="btn btn-default btn-lg btn-block"
					style="margin-top: 20px;">Visualizza le Statistiche</button>
				</a>
				<a href="gestioneCorsi.jsp">		
				<button type="button" class="btn btn-default btn-lg btn-block"
					style="margin-top: 20px;">Gestisci Corsi</button>
				</a>
			</div>
			<div class="col-sm-2 col-md-4"></div>
		</div>
	</div>

	<footer class="footer"><%@include file="footer.html"%></footer>

</body>
</html>
<%
} else {
response.sendRedirect("accessoNegato.jsp");
}
%>