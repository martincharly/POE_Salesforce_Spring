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
<title>TeamManager - Création d'un joueur</title>
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

	<h2>Créer un joueur</h2> <br>
	
	<form action="" method="post">
		Nom : <input type="text" name="lastName"/> <br>
		Prénom : <input type="text" name="firstName" /> <br>
		Date de naissance : <input type="date" name="birthday" /> <br>
		Poste : <select name="position">
					<option value="Forward">Attaquant</option>
					<option value="Midfielder">Milieu</option>
					<option value="Defender">Défenseur</option>
					<option value="Goalkeeper">Gardien</option>
				</select> <br>
		Numéro : <input type="number" name="kitNumber"> <br>
		Email : <input type="text" name="email"> <br>
		
		<input type="submit" value="Ajouter le joueur" />
	
	</form>

</body>
</html>