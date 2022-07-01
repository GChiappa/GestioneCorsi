
<%
String username = (String) session.getAttribute("admin");
String home = "paginaPrincipale.jsp";
if (username == null) {
	home = "index.jsp";
}
%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#menuApp">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=home%>">Management Alfacom</a>
			<ul class="nav navbar-nav">
				<li><a href="chisiamo.jsp">Chi siamo</a></li>
			</ul>
		</div>
		<div class="collapse navbar-collapse" id="menuApp">

			<%
			if (username == null) {
			%>
			<ul class="nav navbar-nav navbar-right">

				<li><a href="login.jsp"> <span
						class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;Login
				</a></li>
			</ul>
			<%
			} else {
			String nome = (String) session.getAttribute("nome");
			%>

			<ul class="nav navbar-nav">
				<li><a href="gestioneCorsisti.jsp">Gestione Corsisti</a></li>
				<li><a href="statistiche.jsp">Statistiche</a></li>
				<li><a href="gestioneCorsi.jsp">Gestione Corsi</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">

				<li><a href="#"> <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<%=nome%>

				</a></li>
				<li><a href="logout.jsp"> <span
						class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;Logout
				</a></li>
			</ul>
			<%
			}
			%>
		</div>
	</div>
</nav>