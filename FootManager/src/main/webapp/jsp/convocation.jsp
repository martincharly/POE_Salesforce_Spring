<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" /><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>TeamManager - Convocation</title>
</head>
<body class="backgroundLogin">
	<header>
		<nav>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a class="nav-link active"
					href="player/team">Effectif</a></li>
				<li class="nav-item"><a class="nav-link"
					href="player/newPlayer">Joueur</a></li>
				<li class="nav-item"><a class="nav-link" href="newMatch">Match</a></li>
				<li class="nav-item"><a class="nav-link" href="newMatchSheet">Feuille
						de match</a></li>
				<li class="nav-item"><a class="nav-link" href="season">Saison</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Se
						déconnecter</a></li>
			</ul>
		</nav>
	</header>

	<table>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Sélectionner</th>
		</tr>



		<tr>
			<td></td>
			<td></td>
			<td><input type="checkbox" value="sélectionner" /></td>
		</tr>



	</table>

</body>
</html>