<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
<meta charset="ISO-8859-1">
<title>TeamManager - Création d'un match</title>
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

	<h2>Saisir un match</h2>
	
	<form action="" method="post">
		Date : <input type="date" name="dateMatch"/> <br>
		Lieu : <input type="text" name="location" /> <br>
		Type : <select name="type">
					<option value="Friendly">Amical</option>
					<option value="Official">Officiel</option>
				</select> <br>
		Adversaire : <input type="text" name="opponent"> <br> 
		Buts marqués : <input type="number" name="goalsScored"> <br>
		Buts encaissés : <input type="number" name="goalsConceded"> <br>
		
		<input type="submit" value="Ajouter le match" />
	
	</form>

</body>
</html>