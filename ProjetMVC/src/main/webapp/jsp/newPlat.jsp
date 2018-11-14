<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouveau plat</title>
</head>
<body>

	<h1>Ajouter un plat</h1>
	
	<form method="post" action="">
		
		Type du plat
		<select name="typePlat">
			<option value="ENTREE">Entrée</option>
			<option value="PLAT">Plat</option>
			<option value="ACCOMPAGNEMENT">Accompagnement</option>
			<option value="DESSERT">Dessert</option>
		</select><br>
		
		<label for="nom">Nom</label>
		<input type="text" name="nom"/><br>
		
		<label for="nom">Prix</label>
		<input type="number" name="prix"/><br>
		
		<input type="submit" value="Créer" />
	
	</form>

</body>
</html>