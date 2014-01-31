<%@page import="java.io.PrintWriter"%>
<%@page import="com.tackit.DTO.Pin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tackit.DTO.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tack -IT</title>

</head>
<body>
	
	<%@include file="Navbar.jsp"%>
	<table width="100%" class="table-striped">
	<tr >
	</tr>
	<tr class="table-danger">
	<td width="20%">
	
		<jsp:include page="LeftNavBar.jsp"></jsp:include>
	
	</td>
	<td width="60%">
	 
	
	<jsp:include page="DataView.jsp"></jsp:include>
	
	
	</td>
	<td width="20%">
	
		<jsp:include page="RightNavBar.jsp"></jsp:include>
	
	
	</td>
	</tr>
	</table>
</body>
</html>