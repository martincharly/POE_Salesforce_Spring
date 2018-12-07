<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
<title>TeamManager - Saisie d'une feuille de match</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body class="backgroundLogin">
	<header>
		<div class="logoZone">
			<img src="css/images/logo.PNG" class="navLogo" />
			<h1>FootManager</h1>
		</div>
		<nav>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a class="nav-link active"
					href="player/team">Effectif</a></li>
				<li class="nav-item"><a class="nav-link" href="season">Saison</a></li>
				<li class="nav-item"><a class="nav-link"
					href="player/newPlayer">Joueur</a></li>
				<li class="nav-item"><a class="nav-link" href="newMatch">Match</a></li>
				<li class="nav-item"><a class="nav-link" href="newMatchSheet">Feuille
						de match</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Se
						déconnecter</a></li>
			</ul>
		</nav>
	</header>

	<div class="formPlayer">
		<h2>Saisir feuille de match</h2>

		<form action="" method="post">

			Match : <select name="idMatch">
				<core:forEach var="match" items="${ listeMatch }">
					<option value="${ match.id }">Nantes - ${ match.opponent }
						[${ match.dateMatch }]</option>
				</core:forEach>
			</select> <br> Joueur : <select name="idPlayer">
				<core:forEach var="player" items="${ listePlayer }">
					<option value="${ player.id }">${ player.lastName }
						${player.firstName }</option>
				</core:forEach>
			</select> <br>
			Buts : <input type="number" name="goals" min="0" max="10" value="0"> <br>
			Passes: <input type="number" name="assists" min="0" max="10" value="0"> <br>

			<input type="submit" value="Valider feuille de match"
				class="btn-login" />

			<div id="matchsheet-added">${msg}</div>

		</form>
	</div>

</body>
</html>