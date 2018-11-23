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
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body class="backgroundLogin">
<header>
<nav>
<ul class="nav justify-content-center">
<li class="nav-item"><a class="nav-link active" href="player/team">Effectif</a></li>
<li class="nav-item"><a class="nav-link" href="player/newPlayer">Joueur</a></li>
<li class="nav-item"><a class="nav-link" href="newMatch">Match</a></li>
<li class="nav-item"><a class="nav-link" href="newMatchSheet">Feuille de match</a></li>
<li class="nav-item"><a class="nav-link" href="season">Saison</a></li>
<li class="nav-item"><a class="nav-link disabled" href="login">Se déconnecter</a></li>
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
		</select> <br> 
		Joueur : <select name="idPlayer">
			<core:forEach var="player" items="${ listePlayer }">
				<option value="${ player.id }">
				${ player.lastName } ${player.firstName }
				</option>
			</core:forEach>
		</select> <br>
		Buts : <input type="number" name="goals" min="0" max="10"> <br> 
		Passes: <input type="number" name="assists" min="0" max="10"> <br>
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
		<input type="submit" value="Valider feuille de match" class="btn-login"/>
	
	</form>
	</div>
${msg}
</body>
</html>