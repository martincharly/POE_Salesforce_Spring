<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
<title>TeamManager - Création d'un joueur</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body class="backgroundLogin">
	<header>
		<div class="logoZone">
			<img src="css/images/logo.PNG" class="navLogo"/>
			<h1>FootManager</h1>
		</div>
		<nav>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a class="nav-link active" href="player/team">Effectif</a></li>
				<li class="nav-item"><a class="nav-link" href="season">Saison</a></li>
				<li class="nav-item"><a class="nav-link" href="player/newPlayer">Joueur</a></li>
				<li class="nav-item"><a class="nav-link" href="newMatch">Match</a></li>
				<li class="nav-item"><a class="nav-link" href="newMatchSheet">Feuille de match</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Se déconnecter</a></li>
			</ul>
		</nav>
	</header>


		<div class="formPlayer">
			<h2>Créer un joueur</h2>
			
			<form action="" method="post">
				Nom : <input type="text" name="lastName"/><br>
				Prénom : <input type="text" name="firstName"/><br>
				Date de naissance : <input type="date" name="birthday" placeholder="Date de naissance"/><br>
				Poste : <select name="position">
					<option value="Forward">Attaquant</option>
					<option value="Midfielder">Milieu</option>
					<option value="Defender">Défenseur</option>
					<option value="Goalkeeper">Gardien</option>
				</select><br>
				Numéro : <input type="number" name="kitNumber"><br>
				Email : <input type="text" name="email"><br>
				<input type="submit" value="Ajouter le joueur" class="btn-login"/>
		
			</form>
			
		</div>

</body>
</html>