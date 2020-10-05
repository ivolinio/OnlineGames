<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account</title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/styles/home-style.css"/>
   
</head>

<body text = "gold">
<form action="delete" method="post">
<h1>Are you sure you want to delete your accaunt?</h1>
<a href="http://localhost:8080/MyWebProject1/Home"><input type="button" name="goBack" value="Go Back">
</a>
<br>
<br><br>
<input type="text" name="username" placeholder="username" />
<input type="submit" value="Delete my acaunt" />


</form>
</body>
</html>