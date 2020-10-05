<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/styles/reset-css.css"/>
    <link rel="stylesheet" type="text/css" href="static/styles/home-style.css"/>
    <link rel="stylesheet" type="text/css" href="static/styles/navigation.css"/>
    <link rel="stylesheet" type="text/css" href="static/styles/form-style.css"/>
</head>
<body>
<div class='container'>
    <main id="pageWrapper">
        <div class='authentication-container'>
            <form class="form form-login" action="login" id="loginForm" method="post">
               
                <div class="form-control">
                    <label for="username">Eter your username</label>
                    <input type="text" id="username" name="username" placeholder="Enter username"/>
                </div>
                <div class="form-control">
                    <label for="password">Enter your password</label>
                    <input type="password" id="password" name="password" placeholder="Enter password"/>
                </div>
                <button class="btn" id="submitLogin">Login</button>
                <a href="http://localhost:8080/MyWebProject1/register" style="color:white">SignIn</a>
            </form>
        </div>
    </main>
</div>

</body>
</html>
