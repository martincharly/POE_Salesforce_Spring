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
				<form action="login" method="post">
					<input type="text" name="userName" placeholder="Nom d'utilisateur"/> <br/>
					<input type="password" name="password" placeholder="Mot de passe"/> <br/>
					<input type="submit" value="Se connecter" class="btn-login"/>
				</form>
			</div>
		</body>
</html>