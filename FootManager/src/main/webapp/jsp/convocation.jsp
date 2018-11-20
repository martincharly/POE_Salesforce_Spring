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
<title>TeamManager - Convocation</title>
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
			<th>Sélectionner</th>
		</tr>
		

		
		<tr>
			<td></td>
			<td></td>			
			<td><input type="checkbox" value="sélectionner"/></td>			
		</tr>
		

		
	</table>
	
</body>
</html>