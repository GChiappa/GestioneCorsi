
<%
//if (session.getAttribute("admin") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Report Statistiche</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">

		<div class="row">

			<h3>Corsisti</h3>
			<h5>Totale X</h5>

			<div class="panel-group" id="corsi" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h3 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#corsi"
								href="#collapseOne" aria-expanded="true"
								aria-controls="collapseOne"> Elenco Corsisti </a>
						</h3>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body"></div>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<h3>Corso più frequentato</h3>

			<!-- Stampa Corso e recupera percentuale -->
			<%
			double percentuale = 28;
			%>

			<div class="progress">
				<div class="progress-bar progress-bar-success"
					style="width: <%=percentuale%>%">
					<span class="sr-only"><%=percentuale%>% Complete (success)</span>
				</div>
				<div class="progress-bar progress-bar-warning progress-bar-striped"
					style="width: <%=100 - percentuale%>%">
					<span class="sr-only"><%=100 - percentuale%>% Complete
						(warning)</span>
				</div>
			</div>

		</div>

		<div class="row">
			<h3>Inizio dell'ultimo corso</h3>
		</div>

		<div class="row">
			<h3>Durata media dei corsi</h3>
		</div>

		<div class="row">

			<h3>Commenti dei Corsisti</h3>
			<h5>Totale: X</h5>

			<div class="panel-group" id="commenti" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h3 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#commenti"
								href="#collapseTwo" aria-expanded="true"
								aria-controls="collapseTwo"> Tutti i Commenti </a>
						</h3>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body"></div>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<h3>Docente con più corsi</h3>

			<div class="panel-group" id="docente" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingThree">
						<h3 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#docente"
								href="#collapseThree" aria-expanded="true"
								aria-controls="collapseTwo"> Corsi del Docente </a>
						</h3>
					</div>
					<div id="collapseThree" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body"></div>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<h3>Corsi con posti disponibili</h3>

			<div class="panel-group" id="corsiliberi" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingFour">
						<h3 class="panel-title">
							<a role="button" data-toggle="collapse"
								data-parent="#corsiliberi" href="#collapseFour"
								aria-expanded="true" aria-controls="collapseTwo"> Elenco
								corsi </a>
						</h3>
					</div>
					<div id="collapseFour" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body"></div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<footer><%@include file="footer.html"%></footer>
</body>
</html>

<%
/*} else{
response.sendRedirect("index.jsp");
}*/
%>