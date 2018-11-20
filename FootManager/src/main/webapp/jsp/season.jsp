<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TeamManager - Saison</title>
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
			<th>Date</th>
			<th>Lieu</th>
			<th>Type</th>
			<th>Adversaire</th>
			<th>Buts inscrits</th>
			<th>Buts encaissés</th>
		</tr>
		
		<core:forEach var="match" items="${ listeMatch }">
		
		<tr>
			<td>${ match.dateMatch }</td>
			<td>${ match.location }</td>
			<td>${ match.type }</td>
			<td>${ match.opponent }</td>
			<td>${ match.goalsScored }</td>
			<td>${ match.goalsConceded }</td>
			
		</tr>
		

		</core:forEach>
	</table>

</body>
</html>