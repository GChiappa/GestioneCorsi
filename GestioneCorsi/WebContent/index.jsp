<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
<title>Error 404</title></head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
 <div class="page-header">
  <h3>Pagina non trovata</h3> 
 </div>
 <div class="panel panel-danger">
  <div class="panel-heading">
   <h3>Impossibile caricare la risorsa richiesta</h3>
  </div>
   <div class="panel-body">
    <p>Siamo spiacenti del disagio risolveremo al più presto</p>
    <p>Per segnalare il problema:&nbsp;
    <a href="mailto:max@tin.it">Email Amministratore</a>
    <p>Oppure torna alla pagina precedente:</p>
    <input type="button" class="btn btn-default" 
    value="Indietro" onclick="window.history.back()" /> 
    
   </div>
 </div>
</div>
<footer class="footer"><%@ include file="footer.html"%></footer>
</body>
</html>