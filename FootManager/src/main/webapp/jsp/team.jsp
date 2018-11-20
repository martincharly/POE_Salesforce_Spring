<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
<meta charset="ISO-8859-1">
<title>TeamManager - Effectif</title>
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

	<table>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Date de naissance</th>
			<th>Poste</th>
			<th>Numéro</th>
			<th>Buts</th>
			<th>Passes</th>
<!-- 			<th>Cartons</th> -->
			<th>Matches</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		

		<core:forEach var="player" items="${ listePlayer }">
		<tr>
			<td>${player.lastName}</td>
			<td>${player.firstName}</td>
			<td>${player.birthday}</td>
			<td>${player.position}</td>
			<td>${player.kitNumber}</td>
			<td>${player.nbGoals}</td>
			<td>${player.nbAssists}</td>
<!-- 			<td></td> -->
			<td></td>
			<td>${player.email}</td>				
			<td></td>				
		</tr>
		

</core:forEach>	
	</table>
	${msg}
</body>
</html>