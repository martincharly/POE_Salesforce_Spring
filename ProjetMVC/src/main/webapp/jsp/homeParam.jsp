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
		<title>Accueil</title>
	</head>
	<body>
		<h2>Accueil de la cantine ${ param1 }</h2>
	</body>
</html>