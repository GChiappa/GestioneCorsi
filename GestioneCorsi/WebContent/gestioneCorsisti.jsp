
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
						<form
							action="/<%=application.getServletContextName()%>/removeCorso">
							<input type="hidden" name="corso"
								value="<%=corsisti[i].getCodCorsista()%>">
							<button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-book"></span>
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