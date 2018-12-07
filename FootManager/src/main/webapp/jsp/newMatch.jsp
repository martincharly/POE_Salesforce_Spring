<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>TeamManager - Création d'un match</title>
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
		<h2>Saisir un match</h2>


		<form action="" method="post">
			Date : <input type="date" name="dateMatch" /> <br>
			Lieu : <input type="text" name="location" /> <br>
			Type : <select name="type">
						<option value="Friendly">Amical</option>
						<option value="Official">Officiel</option>
					</select> <br>
			Adversaire : <input type="text" name="opponent"> <br>
			Buts marqués : <input type="number" name="goalsScored" min="0" max="15" required> <br>
			Buts encaissés : <input type="number" name="goalsConceded" min="0" max="15" required> <br>
			<input type="submit" value="Ajouter le match" class="btn-login" />

		</form>
	</div>

</body>
</html>