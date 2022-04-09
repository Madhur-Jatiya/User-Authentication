<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>
<body>
		<h1>LogIn</h1>
	
	<form action="users" method = "post">
	<input type="hidden" name="task" value="login">
		Enter Username : <input type = "text" name = "logInUsername"> <br><br>
		Enter Password : <input type = "password" name = "logInPswd"> <br><br>
		<button type="submit">Submit</button>
		<button type ="reset">Reset</button>
	</form>
</body>
</html>