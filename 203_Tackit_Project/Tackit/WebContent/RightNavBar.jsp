<%@page import="com.tackit.DTO.Board"%>
<%@page import="com.tackit.DTO.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<br>
<br>
<br>
<br>
<br>
<br>
<br>
	<%
		User usrObj = (User) session.getAttribute("userInfo");
		
	%>
	<table class="well">
		<tr>
		<h4>
			&nbsp;&nbsp;&nbsp;&nbsp;Suggested Boards
		</h4>
		</tr>
		<tr>
		<%
			for(Board board:usrObj.getuBSuggestionList())
			{
		%>
			<div class="row">
			<form action="SBoard" method="post">
			<input type="hidden" value="<%=board.getBoardId()%>" name="bId">
			<input type="hidden" value="<%=board.getBoardName()%>" name="bName">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-link" value="<%=board.getBoardName()%>" style="color:#000000;">
			</form>
			</div>
		<%} %>
		</tr>
		
	</table>
	
	
	
	
</body>
</html>