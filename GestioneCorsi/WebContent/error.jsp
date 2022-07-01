<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">

		<div class="pb-2 mt-4 mb-2">
			<h1>Errore nella pagina</h1>
		</div>
		<%
		if (exception instanceof ClassNotFoundException) {
		%>
		<div class="panel panel-danger">
			<div class="panel-body">
				<h5 class="card-title"><%=exception.getClass().getName()%></h5>
				<h6 class="card-subtitle mb-2 text-muted">Eccezione durante la
					ricerca della classe</h6>
				<p class="card-text"><%=exception.getMessage()%></p>
				<a href="home.jsp"><button class="btn btn-outline-dark">Home</button></a>
				<button onclick="window.history.back()" class="btn btn-outline-dark">Indietro</button>
			</div>
		</div>

		<%
		} else if (exception instanceof ServletException) {
		%>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h5 class="card-title"><%=exception.getClass().getName()%></h5>
			</div>
			<div class="panel-body">
				<h6 class="card-subtitle mb-2 text-muted">Eccezione durante
					operazioni della Servlet</h6>
				<p class="card-text"><%=exception.getMessage()%></p>
				<a href="home.jsp"><button class="btn btn-outline-dark">Home</button></a>
				<button onclick="window.history.back()" class="btn btn-outline-dark">Indietro</button>
			</div>
		</div>

		<%
		} else {
		%>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h5 class="card-title"><%=exception.getClass().getName()%></h5>
			</div>
			<div class="panel-body">
				<h6 class="card-subtitle mb-2 text-muted">Eccezione non
					prevista</h6>
				<p class="card-text"><%=exception.getMessage()%></p>
				<p>
					StackTrace:
					<%
				exception.printStackTrace(new PrintWriter(out));
				%>
				</p>
				<a href="home.jsp"><button class="btn btn-outline-dark">Home</button></a>
				<button onclick="window.history.back()" class="btn btn-outline-dark">Indietro</button>
			</div>
		</div>
		<%
		}
		%>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>