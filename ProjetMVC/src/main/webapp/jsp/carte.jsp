<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme() + "://"
		+ request.getServerName() + ":"
		+ request.getServerPort()
		+ request.getContextPath() + "/"
		%>" />
<meta charset="ISO-8859-1">
<title>Carte</title>
</head>
<body>
	<h1>Voici notre carte</h1>
	
	<table>
		<tr>
			<th>Type</th>
			<th>Plat</th>
			<th>Prix</th>
			<th>Action</th>
		</tr>
		<!--  Début du foreach -->
		<core:forEach var="plat" items="${ listePlats }">
		<tr>
			<td>${ plat.typePlat }</td>
			<td>${ plat.nom }</td>
			<td>${ plat.prix }</td>
			<td>
				<form action="plat/delete" method="post">
					<input type="hidden" name="id" value="${ plat.id }" />
					<input type="submit" value="Supprimer" />
				</form>
			</td>
		</tr>
		</core:forEach>
		<!--  Fin du foreach -->
	</table>
	
	${ msg }
	
</body>
</html>