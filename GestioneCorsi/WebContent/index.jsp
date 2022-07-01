<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/all.css">
</head>

<body>

	<div class="row">
		<img src="img/c.jpg" alt="Image" height="10" width="200%">
	</div>
	
	<div class="container">
	
		<form role="form" action="/<%=application.getServletContextName()%>/controlloAdmin" method="post">
			<div class="row" style="margin-top: 20px">
				<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">

					<h3 style="text-align: center">
						Accedi a <strong>Management Alfacom</strong>
					</h3>
					<hr class="colorgraph">
					<div class="form-group">
						<input type="text" name="admin" id="codice" class="form-control"
							placeholder="Il tuo codice amministratore">
					</div>
					<div class="form-group">
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Password">
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12"
						style="text-align: center; background-color: img-src">
						<input type="submit" class="btn btn-outline-dark" value="Accedi">
					</div>

				</div>

			</div>
		</form>
		<div>
			<br>
			<p style="text-align: center">
				Non hai un Account? <a href="">Crea subito il tuo.</a>
			</p>
		</div>

		<div class="riguardonoi"><%@include file="riguardonoi.html"%></div>

	</div>

	<div class="jumbotron" style="margin-top: 60px; text-align: center; ">
	
			<h2>Perchè la sicurezza nella gestione dei corsi...</h2>
			<p>
				Per noi è tutto! affidati a questa fantastica piattaforma<br>e
				noi ti aiuteremo a rendere i tuoi sogni realtà
			</p>
			<p>
				<a class="btn btn-outline-dark btn-lg" href="login.jsp"
					role="button">Accedi al tuo account</a>
			</p>
	
	</div>

</body>