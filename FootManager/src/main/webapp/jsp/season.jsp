<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>TeamManager - Saison</title>
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

	<div class="table-background">
	<table class="table table-hover">
		<tr>
			<th scope="col">Date</th>
			<th scope="col">Lieu</th>
			<th scope="col">Type</th>
			<th scope="col">Adversaire</th>
			<th scope="col">Buts inscrits</th>
			<th scope="col">Buts encaissés</th>
		</tr>

		<core:forEach var="match" items="${ listeMatch }">

			<tr>
				<td scope="row">${ match.dateMatch }</td>
				<td scope="row">${ match.location }</td>
				<td scope="row">${ match.type }</td>
				<td scope="row">${ match.opponent }</td>
				<td scope="row">${ match.goalsScored }</td>
				<td scope="row">${ match.goalsConceded }</td>

			</tr>


		</core:forEach>
	</table>
	</div>

</body>
</html>