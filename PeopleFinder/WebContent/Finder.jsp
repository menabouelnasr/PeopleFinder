<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a:link {    /* unvisited link */color: black; text-decoration: none}
a:visited {    /* visited link */color: black;}
a:hover {    /* mouse over link */color: red; text-decoration: underline;}
a:active {    /* active link */color: black;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People Finder</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="text-center">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">People Finder</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
        </div>
      </div>
    </nav>
<br />
<br />
    <div class="text-center">
    <p></p>
        <p class="lead">Please complete all necessary fields.</p>
      </div>
<form class= "text-center" action="Inputs"  method="post">
First name (Uppercase):<br>
<input type="text" placeholder= "ex. John" name="Fname"> </input><br>
<br>
Last name (Uppercase):<br>
<input type="text" placeholder= "ex. Smith" name="Lname"></input><br>
<br>
<input href="Inputs" type=submit name=submit  value="Find"> </input>
</form>
</body>
</html>