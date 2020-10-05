<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Games</title>

<style> body {
  background: url("assets/Wallpaper.jpg");
  background-repeat: no-repeat;
  background-size: cover;
}

	textarea{
	background-color:silver;
	width:129px;
	height:204px;
	}

	.container {
	display: flex;
	}
	.empty-list {
	width:135px;
	height:210px;
	border: 4px solid #98EC48;
	box-shadow: 3px 3px 10px 5px  #98EC48;	
	background: url("assets/img1.jpg");
    background-size: contain;
	}
	
	#score {
			height: 80px;
			width: 400px;
			background: 887D3E;
			background-size: contain;
			outline: 3px solid #98EC48;
			 box-shadow: 3px 3px 10px 10px  #98EC48;
			
			
			position: relative;
			left:170px;
            top:-306px;	
			
		}
		
	#button {
     line-height: 12px;
     width: 18px;
     font-size: 8pt;
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 2px;
     position:absolute;
     top:7px;
     right:100px;
 }
	
</style>
</head>


<body text = "gold" onload="image">
<script>

</script>
<form method = "post" action="Home">

Welcome you are logged as user: <%=session.getAttribute("uname") %>
<a href="http://localhost:8080/MyWebProject1/logout"><input type="button" name="log-out" value="LogOut">
</a>



<marquee direction="left"> 
<h1> Select a game to play from the menu list and enjoy! </h1>
</marquee>

<select name="List" id="list">
	<option value="The Labirint">The Labirint</option>
	<option value="Shadow Fight">Shadow Fight</option>
	<option value="Snake">Snake</option>
	<option value="GTA IV">GTA IV</option>
</select><input type="submit" name="Play" value="play">
<input type="hidden" name="user" value="<%=session.getAttribute("uname")%>"/>

<br></br>
<input type="button" value="reset" id="reset"/>
<input type="button" name="Select" value="select" id="select">
<input type="submit" id="buy" name="buy" value="Buy"/>

    
<div class="container">
<div class = "empty-list">

<textarea id="textarea" name = "bill" style="background-color:#A1C679;" rows="14" cols="16" >
<%=request.getSession().getAttribute("bill")%>
</textarea>


</div> 
</div>
<div id ="score">
<h2>Please insert address for your delivery.</h2>
<input type="text" id="address" name="address" maxlength="200" size="57"  />
</div>

<input type='file' name="file"/>
<br><img id="myImg" src="#" alt="your image" height=200 width=100>

<div id ="button">
<a href="http://localhost:8080/MyWebProject1/delete"><input type="button" name="Delete" value="Delete Acaunt">
</a>
</div>


</form>

  
<script type="text/javascript" src="lib/jquery-3.5.1.min.js"> </script>
<script type="text/javascript" src="lib/code1.js"> </script>
  
</body>
</html>