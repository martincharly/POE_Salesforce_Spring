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
<title>TeamManager</title>
</head>
<body>

	<form action="login" method="post">
		UserName : <input type="text" name="userName" /> <br>
		Password : <input type="password" name="password" /> <br>
		<input type="submit" value="Se connecter" />
	</form>

</body>
</html>