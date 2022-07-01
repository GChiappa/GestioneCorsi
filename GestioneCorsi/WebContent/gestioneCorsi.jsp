
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
<title>Corsi</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div class="page-header">
			<h1>
				Gestione dei corsi <small>Clicca sul cestino per eliminarlo.</small>
			</h1>
		</div>
		<%
		Corso[] corsi = AdminFacade.getInstance().getCorsi();
		%>

		<table class="table table-hover" style="text-align: center; margin-top: 50px;">

			<thead>
				<tr>
					<td>Codice</td>
					<td>Nome</td>
					<td>Docente</td>
					<td>Aula</td>
					<td>Inizio</td>
					<td>Fine</td>
					<td></td>
				</tr>
			</thead>

			<tbody>
				<%
				for (int i = 0; i < corsi.length; i++) {
				%>
				<tr>
					<td><%=corsi[i].getCodCorso()%></td>
					<td><%=corsi[i].getNome()%></td>
					<%
					Docente doc = AdminFacade.getInstance().findDocByCod(corsi[i].getCodDocente());
					%>
					<td><%=doc.getNome()%> <%=doc.getCongnome()%></td>
					<td><%=corsi[i].getAula()%></td>
					<td><%=corsi[i].getInizioCorso()%></td>
					<td><%=corsi[i].getFineCorso()%></td>
					<td>
						<form
							action="/<%=application.getServletContextName()%>/removeCorso" method="post">
							<input type="hidden" name="corso"
								value="<%=corsi[i].getCodCorso()%>">
							<button type="submit" class="btn btn-danger">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</form>
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