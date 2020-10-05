<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/styles/home-style.css"/>
   
<head>
<meta charset="ISO-8859-1">
<title>Log out</title>
</head>
<h1>Are u sure u want to logout from <%=session.getAttribute("uname") %>'s accaunt?
</h1>
<body text = "gold">

<form method="post" action="logout">

<a href="http://localhost:8080/MyWebProject1/Home"><input type="button" name="Go Back" value="Go Back"> </a>


<input type="submit" name="log-out" value="LogOut">



</form>

</body>

</html>