<html>
<head>
	<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
</head>
<body>

	<h1>Bienvenue à la cantine !</h1>
	
	<a href="accueil">Accueil de la cantine</a> <br>
	<a href="default">Accueil de la cantine</a> <br>

	<form action="accueil" method="post">
		Lieu <input type="text" name="lieu" />
		Date de réouverture <input type="date" name="dateReouverture" />
		<input type="submit" />
	</form>
	
	<a href="home2/demo">Alternative de remplacement subsidiaire 2</a> <br>
	<a href="home2/demo/tutu">Avec un paramètre</a> <br>
	
	<a href="menu/Vegetarien/Day/lundi">Le menu du jour</a> <br>
	
	<a href="carte">Accès à notre carte</a> <br>
	
	<a href="plat/new">Ajouter un plat</a>
	
	
	
</body>
</html>
