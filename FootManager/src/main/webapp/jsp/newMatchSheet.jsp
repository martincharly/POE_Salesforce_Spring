<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
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
<form action="" method="post">

		Match : <select name="idMatch">
			<core:forEach var="match" items="${ listeMatch }">
				<option value="${ match.id }">Nantes - ${ match.opponent }
					[${ match.dateMatch }]</option>
			</core:forEach>
		</select> <br> 
		Joueur : <select name="idPlayer">
			<core:forEach var="player" items="${ listePlayer }">
				<option value="${ player.id }">
				${ player.lastName }
				</option>
			</core:forEach>
		</select> <br>
		Buts : <input type="number" name="goals"> <br> 
		Passes: <input type="number" name="assists"> <br>
<!-- 		Cartons : <select name="cards"> -->
<!-- 					<option value="none">Aucun</option> -->
<!-- 					<option value="yellow">Jaune</option> -->
<!-- 					<option value="red">Rouge</option> -->
<!-- 				</select> <br> -->
<!-- 		Note : <select name="mark"> -->
<!-- 					<option value="0">0</option> -->
<!-- 					<option value="1">1</option> -->
<!-- 					<option value="2">2</option> -->
<!-- 					<option value="3">3</option> -->
<!-- 					<option value="4">4</option> -->
<!-- 					<option value="5">5</option> -->
<!-- 				</select> <br> -->
		<input type="submit" value="Valider feuille de match" />
	
	</form>

</body>
</html>