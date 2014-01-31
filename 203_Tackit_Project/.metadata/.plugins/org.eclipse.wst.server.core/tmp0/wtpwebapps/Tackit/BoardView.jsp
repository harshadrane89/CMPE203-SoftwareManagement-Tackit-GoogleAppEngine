<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tackit<%=session.getAttribute("bName")%> </title>
<%@include file="Navbar.jsp"%>
</head>
<body>

	<table width="100%">
	<tr>
	</tr>
	<tr>
	<td width="20%">
	
		<jsp:include page="LeftNavBar.jsp"></jsp:include>
	
	</td>
	<td width="60%">
	 
	
	<jsp:include page="DataBoardView.jsp"></jsp:include>
	
	
	</td>
	<td width="20%">
	
		<jsp:include page="RightNavBar.jsp"></jsp:include>
	
	
	</td>
	</tr>
	</table>
</body>
</html>