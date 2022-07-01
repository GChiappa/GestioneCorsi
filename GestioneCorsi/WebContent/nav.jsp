<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#menuApp">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="paginaprincipale.jsp">Management Alfacom</a>
			 <ul class="nav navbar-nav">
        <li class="active"><a href="#">Homepage</a></li>
        <li><a href="chisiamo.jsp">Chi siamo</a></li>
        <li><a href="faq.jsp">Faq</a></li>
      </ul>
		</div>
		<div class="collapse navbar-collapse" id="menuApp">

			<%
    String username =(String) session.getAttribute("admin");
    if(username == null	)
    {
    %>
			<ul class="nav navbar-nav navbar-right">
				 
				<li>
				<a href="login.jsp"> 
			<span class="glyphicon glyphicon-log-in">Login</span>
				</a>
				</li>
			</ul>
	 <% } else { %>
	 
	 	<ul class="nav navbar-nav">
	 	<li> <a href="gestionecorsi.jsp">Gestione Corsi</a></li>
	 	<li> <a href="statistiche.jsp">Statistiche</a></li>
	 	</ul>
	 	
	 	<ul class="nav navbar-nav navbar-right">
	 	<li>
	 		<a href="Report.jsp">
	 		<span class="glyphicon glyphicon-shopping-cart"></span>
	 		<span class="badge"> Report</span>
	 		</a>
	 	</li>
	 	<li>
	 	<a href="#">
	 	<span class="glyphicon glyphicon-user"></span><%= username %>
	 	
	 	</a>
	 	</li>
	 	<li>
	 	<a href="logout.jsp">
	 	<span class="glyphicon glyphicon-off"></span> Logout
	 	
	 	</a>
	 	</li>
	 	</ul>
			 <%
			 }
			 %>
		</div>
	</div>
</nav>