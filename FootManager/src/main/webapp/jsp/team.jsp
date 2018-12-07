<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>TeamManager - Effectif</title>
</head>

<body class="backgroundTeam">
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
	
<div class="table-background">
	<table class="table table-hover">
		<tr>
			<th scope="col">Nom</th>
			<th scope="col">Prénom</th>
			<th scope="col">Date de naissance</th>
			<th scope="col">Poste</th>
			<th scope="col">Numéro</th>
			<th scope="col">Buts</th>
			<th scope="col">Passes</th>
<!-- 			<th>Cartons</th> -->
			<th scope="col">Matches</th>
			<th scope="col">Email</th>
			<th scope="col">Convoquer</th>
			<th scope="col">Action</th>
		</tr>
		

		<core:forEach var="player" items="${ listePlayer }">
		<tr>
			<td scope="row">${player.lastName}</td>
			<td scope="row">${player.firstName}</td>
			<td scope="row"><fmt:formatDate value="${player.birthday}" pattern="dd/MM/yyyy"/> </td>
			<td scope="row">${player.position}</td>
			<td scope="row">${player.kitNumber}</td>
			<td scope="row">${player.nbGoals}</td>
			<td scope="row">${player.nbAssists}</td>
<!-- 			<td></td> -->
			<td scope="row">${player.nbMatchs}</td>
			<td scope="row">${player.email}</td>
			<td scope="row">
				<form action="player/convoque" method="post">
					<input type="hidden" name="id" value="${ player.id }"/>
					<input type="hidden" name="mailTo" value="${player.email}"/>
					<input type="hidden" name="sujet" value="Convocation au prochain match"/>
					<input type="hidden" name="msg" value="Bonjour ${player.firstName}, tu es convoqué pour le prochain match !"/>
	
					<input type="submit" value="Convoquer"/>
				</form>			
			</td>				
			<td scope="row">
				<form action="player/delete" method="post">
					<input type="hidden" name="id" value="${ player.id }"/>
					<input type="submit" value="Supprimer"/>
				</form>
			</td>				
		</tr>
		

</core:forEach>	
	</table>
	<div id="playerAdded">${msg}</div>
</div>
	
</body>
</html>