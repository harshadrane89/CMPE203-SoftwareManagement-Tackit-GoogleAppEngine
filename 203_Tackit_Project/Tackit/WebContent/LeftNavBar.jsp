<%@page import="com.tackit.DTO.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<Board> bbList = new ArrayList<Board>();
		
		
		for (Board board : usrObj.getBoardList()) {
			bbList.add(board);
		}
		for (Board board : usrObj.getFollowedBoardList()) {
			bbList.add(board);
		}
	%>
	<table class="well">
		<tr>
		<h4>
			&nbsp;&nbsp;&nbsp;&nbsp;Your Boards
		</h4>
		</tr>
		<tr>
		<%
			for(Board board:bbList)
			{
		%>
			<div class="row">
			<form action="Board" method="post">
			<input type="hidden" value="<%=board.getBoardId()%>" name="bId">
			<input type="hidden" value="<%=board.getBoardName()%>" name="bName">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-link" value="<%=board.getBoardName()%>" style="color:#000000;">
			</form>
			</div>
		<%} %>
		</tr>
		<tr>
		
			<form action="Board" method="get">
			<input type="hidden" value="<%=usrObj.getUserId()%>" name="uId">
			<input type="hidden" value="My Pins" name="bName">
			&nbsp;&nbsp;&nbsp;&nbsp;<bold><h4><input type="submit" class="btn btn-link btn-lg" value="Your Pins" style="color:#000000; font:h4;"></h4></bold>
			</form>
		</tr>
	</table>
	
</body>
</html>
	
	
