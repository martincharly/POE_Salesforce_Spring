<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
<title>TeamManager - Saisie d'une feuille de match</title>
</head>
<body>
<header>
<nav>
<ul>
<li><a href="team">Effectif</a></li>
<li><a href="newPlayer">Joueur</a></li>
<li><a href="newMatch">Match</a></li>
<li><a href="newMatchSheet">Feuille de match</a></li>
<li><a href="season">Saison</a></li>
<li><a href="login">Se déconnecter</a></li>
</ul>
</nav>
</header>

<h2>Saisie d'une feuille de match</h2>
<form>
		Match : <input type="number" name="idMatch"/> <br>
		Joueur : <input type="text" name="player" /> <br>
		Buts : <input type="number" name="goals"> <br> 
		Passes: <input type="number" name="assists"> <br>
		Cartons : <select name="cards">
					<option value="none">Aucun</option>
					<option value="yellow">Jaune</option>
					<option value="red">Rouge</option>
				</select> <br>
		Note : <select name="mark">
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select> <br>
		<input type="submit" value="Valider feuille de match" />
	
	</form>

</body>
</html>