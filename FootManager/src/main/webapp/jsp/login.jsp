<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"%>" />
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/style.css" type="text/css"/>
	
	<title>TeamManager</title>
	</head>
	
		<body class="backgroundLogin">
			<div class="formLogin">	
				<img src="css/images/logo.PNG" class="logo"/>
				<h2>Connexion</h2>
				<form action="login" method="post">
					<input type="email" name="email" placeholder="Email" required="required"/> <br/>
					<input type="password" name="password" placeholder="Mot de passe" required="required"/> <br/>
					<input type="submit" value="Se connecter" class="btn-login"/><br>
					<div class="btn-signup"><a href="signup">Nouveau sur FootManager ? S'inscrire</a></div><br>
				</form>
				
				<div id="loginError">
				${msg}
				</div>
			</div>
			
		</body>
</html>