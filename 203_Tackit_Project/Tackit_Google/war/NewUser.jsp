<%@page import="com.tackit.DTO.User"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Shopping Arena</title>

</head>
<body>


	<div class="header">

		<br /> <br /> <br />
		<ul class="nav nav-pills pull-right">
			<li class="active"><a href="Login.jsp">Home</a></li>

		</ul>

		<br /> <br /> <br /> <br />



		<center>
			<h1>Tackit Sign Up</h1>
		</center>
	</div>
	<br>
	<br>
	<center>
		<form action="CreateUser" method="post" class="well">

			<table cellpadding="10px" cellspacing="10px" class="">
				<tr>
					<td>First Name</td>
					<td><input type="text" placeholder="First Name" required
						autofocus name="fName" id="fName" class="form-control"
						value="<%=session.getAttribute("fName") != null ? session
					.getAttribute("fName") : ""%>">
					</td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" placeholder="Last Name" required
						name="lName" id="lName" class="form-control"
						value="<%=session.getAttribute("lName") != null ? session
					.getAttribute("lName") : ""%>">
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" class="form-control"
						placeholder="Email" required name="eMail"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" class="form-control"
						placeholder="Password" required name="passwd"></td>
				</tr>

				<tr>
					<td>Genre</td>
					<td>
					<%
						if (session.getAttribute("userInfo") != null) {
							User userObj=(User)session.getAttribute("userInfo");
							List<String> genList=(List<String>) userObj.getGenreList();
							for(String value:genList)
							{
					%>
						
							
							<input type="checkbox" name="genreList" value="<%=value %>" class="required-one"><%=value %>&nbsp;&nbsp;
							&nbsp;
							&nbsp;
							&nbsp;
						
					<%
							}
							}
					%>
					</td>
				</tr>
			</table>
			<br> <br>
			 <%
 	if (session.getAttribute("error") != null) {
 %> This email id is already under use!!!! <%
 	}
 %>
 <br>
			<button class="btn btn-lg btn-success" type="submit" value="Sign Up">SignUp</button>

		</form>

	</center>
</body>
</html>
