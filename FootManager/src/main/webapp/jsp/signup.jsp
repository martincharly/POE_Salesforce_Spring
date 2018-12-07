<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"%>" />
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/style.css" type="text/css"/>
	
	<title>Inscription</title>
	</head>
	
		<body class="backgroundLogin">
			<div class="formLogin">	
				<img src="css/images/logo.PNG" class="logo"/>
				<h2>Inscription</h2>
				<form action="signup" method="post">
					<input type="email" name="email" placeholder="Email"/> <br/>
					<input type="password" name="password" placeholder="Mot de passe"/> <br/>
					<input type="submit" value="S'inscrire" class="btn-login"/><br>
					<div class="btn-signup"><a href="login">Déjà inscrit(e)? Se connecter</a></div><br>
				</form>
			</div>
		</body>
</html>