<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Register </title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/styles/home-style.css"/>
   
</head>
<body text = "gold">
	<form method ="post" action="register">
	<br>
	<h1>Register page</h1>
	<p>Insert Name and Password</p>
		<br>
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" placeholder="UserName" name="username" required="required" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" placeholder ="Password" name="password"  /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" placeholder ="Confirm Password" name="password2"  /></td>
			</tr>
			<tr>
			
				<td></td>
				<td><input type="submit" value="Register"><a href="http://localhost:8080/MyWebProject1/login"><input type="button" name="Go Back" value="Go to login"> </a>
				</td>
			</tr>
		</table>
	</form> 
</body>
</html>