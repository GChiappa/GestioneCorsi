
<%
if (session.getAttribute("tentativi") != null && (int) session.getAttribute("tentativi") >= 5) {
	response.sendRedirect("troppitentativi.jsp");
}
if (session.getAttribute("admin") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
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
				<%
				if (session.getAttribute("creazione") != null) {
				%>
				<div class="alert alert-danger" role="alert">
					<h3>Creazione Corsista non andata a buon fine</h3>
					<%=session.getAttribute("creazione")%>
				</div>
				<%
				session.removeAttribute("creazione");
				}
				%>
				<a href="#">
					<button type="button" class="btn btn-default btn-lg btn-block"
						style="margin-top: 20px; height: 60px;" data-toggle="modal"
						data-target="#modaleCreaCorsista">Inserisci nuovo
						Corsista</button>
				</a> <a href="gestioneCorsisti.jsp">
					<button type="button" class="btn btn-default btn-block"
						style="margin-top: -8px; height: 30px;">Gestione Corsisti</button>
				</a> <a href="statistiche.jsp">
					<button type="button" class="btn btn-default btn-lg btn-block"
						style="margin-top: 20px;">Visualizza le Statistiche</button>
				</a> <a href="gestioneCorsi.jsp">
					<button type="button" class="btn btn-default btn-lg btn-block"
						style="margin-top: 20px;">Gestisci Corsi</button>
				</a>
			</div>
			<div class="col-sm-2 col-md-4"></div>
		</div>
	</div>

	<footer class="footer"><%@include file="footer.html"%></footer>

</body>
<div class="modal fade" id="modaleCreaCorsista" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Inserimento nuovo
					Corsista</h4>
			</div>
			<form action="/<%=application.getServletContextName()%>/creaCorsista"
				method="post">
				<div class="modal-body">

					<div class="form-group">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" name="nome" id="nome"
							placeholder="Nome Corsista...">
					</div>
					<div class="form-group">
						<label for="cogome">Cogmome</label> <input type="text"
							class="form-control" name="cognome" id="cogome"
							placeholder="Cogome corsista...">
					</div>
					<div class="form-group">
						<label for="precedentiFormativi">Precedenti formativi</label>
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-default"> <input type="radio"
								name="precedentiFormativi" autocomplete="off" value="SI">
								SI
							</label> <label class="btn btn-default"> <input type="radio"
								name="precedentiFormativi" autocomplete="off" value="NO">
								NO
							</label>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
					<button type="submit" class="btn btn-primary">Salva</button>
				</div>
			</form>
		</div>
	</div>
</div>
</html>

<%
} else {
response.sendRedirect("accessoNegato.jsp");
}
%>