
<%@page import="java.util.Vector"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%
if (session.getAttribute("admin") != null) {
%>
<%@page import="it.betacom.businesscomponent.model.Docente"%>
<%@page import="it.betacom.businesscomponent.utility.ReportUtility"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Corsisti</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div class="page-header">
			<h1>
				Gestione dei corsisti <small>Clicca sul <span
					class="glyphicon glyphicon-book"></span> per informazioni sui corsi
					del corsista.
				</small>
			</h1>
		</div>
		<%
		Corsista[] corsisti = AdminFacade.getInstance().getCorsisti();
		%>

		<table class="table table-hover"
			style="text-align: center; margin-top: 50px;">

			<thead>
				<tr>
					<td>Codice</td>
					<td>Nome</td>
					<td>Cognome</td>
					<td>Precedenti Formativi</td>
					<td></td>
					<td></td>
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
					<td>
						<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#modaleCorsiCorsista_<%=corsisti[i].getCodCorsista()%>">
							<span class="glyphicon glyphicon-book"></span>
						</button>
					</td>
					<td>

						<div class="modal fade"
							id="modaleCorsiCorsista_<%=corsisti[i].getCodCorsista()%>"
							tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">
											Corsi seguiti da&nbsp;<%=corsisti[i].getNome()%>&nbsp;<%=corsisti[i].getCognome()%></h4>
									</div>
									<div class="modal-body">

										<%
										ReportUtility ru = new ReportUtility();
										Vector<Corso> corsi = ru.getCorsiCorsista(corsisti[i].getCodCorsista());
										if (corsi.size() > 0) {
										%>

										<table class="table table-hover"
											style="text-align: center; margin-top: 50px;">

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
												for (Corso c : corsi) {
												%>
												<tr>
													<td><%=c.getCodCorso()%></td>
													<td><%=c.getNome()%></td>
													<%
													Docente doc = AdminFacade.getInstance().findDocByCod(c.getCodDocente());
													%>
													<td><%=doc.getNome()%> <%=doc.getCongnome()%></td>
													<td><%=c.getAula()%></td>
													<td><%=c.getInizioCorso()%></td>
													<td><%=c.getFineCorso()%></td>
												</tr>
												<%
												}
												%>
											</tbody>

										</table>
										<%
										} else {
										%>
										<h2>Il corsista non ha mai seguito corsi.</h2>
										<%
										}
										%>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal" style="width: 100%;">Fine</button>
									</div>
								</div>
							</div>
						</div>

					</td>
				</tr>
				<%
				}
				%>
			</tbody>

		</table>

	</div>

	<footer><%@include file="footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("accessoNegato.jsp");
}
%>