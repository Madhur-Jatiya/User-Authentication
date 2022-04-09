<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
		<h1>SignUp</h1>
	
	<form action="users" method = "post">
	<input type="hidden" name="task" value="signup">
		Enter Username : <input type = "text" name = "signUpUsername"> <br><br>
		Enter Password : <input type = "password" name = "signUpPswd1"> <br><br>
		Confrim Password : <input type = "password" name = "signUpPswd2"> <br><br>
		First Name : <input type = "text" name = "firstName"> <br><br>
		Last Name : <input type = "text" name = "lastName"> <br><br>
		Mobile Number : <input type = "tel" name = "mobileNumber" pattern="[0-9]{10}"
       required> <br><br>
		Email Id : <input type = "email" name = "emailId"> <br><br>
		<button type ="submit">SignUp</button>
		<button type ="reset">Reset</button>
	</form>
	
</body>
</html>