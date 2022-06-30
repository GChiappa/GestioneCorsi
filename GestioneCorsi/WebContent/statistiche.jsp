
<%@page import="java.util.Vector"%>
<%@page import="it.betacom.businesscomponent.model.Docente"%>
<%@page import="it.betacom.businesscomponent.CommentoBC"%>
<%@page import="it.betacom.businesscomponent.model.Commento"%>
<%@page import="it.betacom.businesscomponent.utility.ReportUtility"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%
//if (session.getAttribute("admin") != null) {
ReportUtility report = new ReportUtility();
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
			<%
			Corsista[] corsisti = AdminFacade.getInstance().getCorsisti();
			%>
			<h3>Corsisti</h3>
			<h5>
				Totale
				<%=corsisti.length%></h5>

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
						<div class="panel-body">

							<table class="table table-hover" style="text-align: center;">

								<thead>
									<tr>
										<td>Codice</td>
										<td>Nome</td>
										<td>Cognome</td>
										<td>Precedenti Formativi</td>
									</tr>
								</thead>

								<tbody>
									<%
									for (int i = 0; i < corsisti.length; i++) {
									%>
									<tr>
										<td><%=corsisti[i].getCodCorsista()%></td>
										<td><%=corsisti[i].getNome()%></td>
										<td><%=corsisti[i].getCognome()%></td>
										<td><%=corsisti[i].getPrecedentiFormativi()%></td>
									</tr>
									<%
									}
									%>
								</tbody>

							</table>

						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<h3>Corso più frequentato</h3>

			<%
			Corso c = report.getCorsoPiuFreq();
			double percentuale = report.getPercentualeCorso(c.getCodCorso());
			%>

			<div class="alert alert-info" role="alert">
				<h4>
					Corso: "<%=c.getNome()%>"
				</h4>
				<h5>
					Codice:
					<%=c.getCodCorso()%>, Docente:
					<%=c.getCodDocente()%>, Aula:
					<%=c.getAula()%>, Data inizio:
					<%=c.getInizioCorso()%>, Data fine:
					<%=c.getFineCorso()%></h5>
			</div>

			<div class="progress">
				<div class="progress-bar progress-bar-success"
					style="width: <%=percentuale%>%">
					<span class="sr-only"><%=percentuale%>% Complete (success)</span>
				</div>
				<div class="progress-bar progress-bar-info"
					style="width: <%=100 - percentuale%>%">
					<span class="sr-only"><%=100 - percentuale%>% Complete
						(warning)</span>
				</div>
			</div>

		</div>

		<div class="row">
			<h3>
				Inizio dell'ultimo corso: <strong><%=AdminFacade.getInstance().getInizioUltimoCorso()%></strong>
			</h3>
		</div>

		<div class="row">
			<h3>Durata media dei corsi: X giorni lavorativi</h3>
		</div>

		<div class="row">

			<%
			Commento[] commenti = AdminFacade.getInstance().getCommenti();
			%>

			<h3>Commenti dei Corsisti</h3>
			<h5>
				Totale:
				<%=commenti.length%></h5>

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
						<div class="panel-body">

							<table class="table table-hover" style="text-align: center;">

								<thead>
									<tr>
										<td>Corso</td>
										<td>Corsista</td>
										<td colspan="4">Commento</td>
									</tr>
								</thead>

								<tbody>
									<%
									for (int i = 0; i < commenti.length; i++) {
									%>
									<tr>
										<td><%=commenti[i].getCodCorso()%></td>
										<td><%=commenti[i].getCodCorsista()%></td>
										<td colspan="4"><%=commenti[i].getDescrizione()%></td>
									</tr>
									<%
									}
									%>
								</tbody>

							</table>

						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<h3>Docente con più corsi</h3>

			<%
			Docente d = report.getDocenteConPiuCorsi();
			Vector<Corso> corsiDoc = report.findCorsiDocente(d.getCodDocente());
			%>

			<div class="alert alert-info" role="alert">
				<h4>
					<%=d.getNome()%>&nbsp;<%=d.getCongnome()%>
				</h4>
				<h6>
					CV:
					<%=d.getCv()%></h6>
			</div>

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
						<div class="panel-body">

							<table class="table table-hover" style="text-align: center;">

								<thead>
									<tr>
										<td>Codice</td>
										<td>Nome</td>
										<td>Aula</td>
										<td>Inizio</td>
										<td>Fine</td>
									</tr>
								</thead>

								<tbody>
									<%
									for (Corso corsoD : corsiDoc) {
									%>
									<tr>
										<td><%=corsoD.getCodCorso()%></td>
										<td><%=corsoD.getCodDocente()%></td>
										<td><%=corsoD.getAula()%></td>
										<td><%=corsoD.getInizioCorso()%></td>
										<td><%=corsoD.getFineCorso()%></td>
									</tr>
									<%
									}
									%>
								</tbody>

							</table>

						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<%
			Corso[] corsiDisp = report.getCorsiDisponibili();
			%>
			<h3>Corsi con posti disponibili</h3>
			<h5>
				Totale:
				<%=corsiDisp.length%></h5>

			<div class="panel-group" id="corsiliberi" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingFour">
						<h3 class="panel-title">
							<a role="button" data-toggle="collapse"
								data-parent="#corsiliberi" href="#collapseFour"
								aria-expanded="true" aria-controls="collapseTwo"> Elenco
								corsi disponibili</a>
						</h3>
					</div>
					<div id="collapseFour" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">

							<table class="table table-hover" style="text-align: center;">

								<thead>
									<tr>
										<td>Codice</td>
										<td>Nome</td>
										<td>Docente</td>
										<td>Aula</td>
										<td>Inizio</td>
										<td>Fine</td>
									</tr>
								</thead>

								<tbody>
									<%
									for (int i = 0; i < corsiDisp.length; i++) {
									%>
									<tr>
										<td><%=corsiDisp[i].getCodCorso()%></td>
										<td><%=corsiDisp[i].getNome()%></td>
										<td><%=corsiDisp[i].getCodDocente()%></td>
										<td><%=corsiDisp[i].getAula()%></td>
										<td><%=corsiDisp[i].getInizioCorso()%></td>
										<td><%=corsiDisp[i].getFineCorso()%></td>
									</tr>
									<%
									}
									%>
								</tbody>

							</table>

						</div>
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