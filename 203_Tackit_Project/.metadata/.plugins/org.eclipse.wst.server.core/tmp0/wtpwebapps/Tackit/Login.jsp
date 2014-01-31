<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
 <link href="css/signin.css" rel="stylesheet">
<title>TackIT- Login</title>
</head>
<body>

 <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active">
          <form action="CreateUser" method="get">
          <input type="submit" class="btn btn-primary btn-lg" value="Signup">
          </form>
          </li>
          
        </ul>
        <h3 class="text-muted">TackIT</h3>
      </div>
      <br>
      <br/>
      <br>
      <br/>
      
	<form class="form-signin" method="post" action="LoginVerify" >
        
        <input type="text" class="form-control" placeholder="Email address" requirRed autofocus width="100px" name="login">
        <input type="password" class="form-control" placeholder="Password" required name="passwd">
       
       <br>
       <br>
       <%if(session.getAttribute("LError1")!=null ) {%>
       <%=session.getAttribute("LError1") %>
       <% }%>
       
       <br>
       <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</div>
</body>
</html>