<%@page import="com.tackit.DTO.Board"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tackit.DTO.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="navbar-fixed-top.css" rel="stylesheet">
</head>
<body>
	<%
		User usrObj = (User) session.getAttribute("userInfo");
		List<String> bList = new ArrayList<String>();
		
		for (Board board : usrObj.getBoardList()) {
			bList.add(board.getBoardName());
		}
		for (Board board : usrObj.getFollowedBoardList()) {
			bList.add(board.getBoardName());
		}
	%>

	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">TackIT</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="Dashboard.jsp">Home</a></li>
					<li><a href="#about">About</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">MyBoard <b class="caret"></b></a>
						<ul class="dropdown-menu">


							<li class="divider"></li>
							<li class="dropdown-header">Your Boards</li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Boards Followed</li>
							<li><a href="#">Create Board</a></li>
						</ul></li>


				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><%=usrObj.getfName()+" "+usrObj.getlName() %> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="divider"></li>
							<li><a href="#creatBoard" id="cBoard" data-toggle="modal">Create
									Board</a></li>
							<li class="divider"></li>
							<li><a href="#createPin" data-toggle="modal">Create Tack</a></li>
							<li class="divider"></li>
							<li><a href="Settings.jsp" >Settings</a></li>
						</ul></li>
					<li>
					
					<form action="UManager" method="get">
						<input type="submit" class="btn btn-link " style="color:#000000;" value="Sign Out">
					</form>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<div id="creatBoard" class="modal fade" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<center>
						<h2>Create Board</h2>
					</center>
				</div>
				<form class="form-horizontal" action="BoardCreator" method="post">
					<div class="modal-body">
						<div class="container">



							<table cellpadding="10px" cellspacing="10px">
								<tr>
									<td><label>Name</label></td>
									<td><input class="form-control" autofocus required="true"
										type="text" class="span4" name="bName"
										placeholder="ex:My Favorite Articles"></td>
								</tr>
								<tr>
									<td><label>Description</label></td>
									<td><textarea class="form-control" class="span4"
											name="bDesc" required placeholder="Description to the Board"></textarea></td>
								</tr>
								<tr>
									<td><label>Genre</label></td>


									<td><select class="form-control" required name="bGenre">
											<%
												for (String boardName : usrObj.getGenre()) {
											%>
											<option><%=boardName%></option>
											<%
												}
											%>
									</select></td>
								</tr>
								<tr>
									<td><label>Secret</label></td>
									<td><input type="radio" name="bType" value="0">
										Yes &nbsp; <input type="radio" name="bType" value="1" checked>&nbsp;No
									</td>

								</tr>

							</table>



						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="Create Board">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div id="createPin" class="modal fade" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<center>
						<h2>Create Tack</h2>
					</center>
				</div>
				<form class="form-horizontal" action="PinInfo" method="post">
					<div class="modal-body">
						<div class="container">



							<table cellpadding="10px" cellspacing="10px">
							<tr>
									<td><label>Name</label></td>
									<td><input class="form-control" autofocus required="true"
										type="text" class="span4" name="pName"
										placeholder="ex: My First Blog"></td>
								</tr>
								<tr>
									<td><label>URL</label></td>
									<td><input class="form-control" autofocus required="true"
										type="text" class="span4" name="pLink"
										placeholder="Link to Tack"></td>
								</tr>
								<tr>
									<td><label>Select Image</label></td>
									<td>
									
										<input type="radio" name="pImage" value="img/main/1.jpg"><img alt="" src="img/thumbs/1.jpg"> 
										<input type="radio" name="pImage" value="img/main/2.jpg"><img alt="" src="img/thumbs/2.jpg">
										<input type="radio" name="pImage" value="img/main/3.jpg"><img alt="" src="img/thumbs/3.jpg"><br>
										<input type="radio" name="pImage" value="img/main/4.jpg"><img alt="" src="img/thumbs/4.jpg">
										<input type="radio" name="pImage" value="img/main/5.jpg"><img alt="" src="img/thumbs/5.jpg">
										<input type="radio" name="pImage" value="img/main/6.jpg"><img alt="" src="img/thumbs/6.jpg"><br>
										<input type="radio" name="pImage" value="img/main/7.jpg"><img alt="" src="img/thumbs/7.jpg">
										<input type="radio" name="pImage" value="img/main/8.jpg"><img alt="" src="img/thumbs/8.jpg">
										<input type="radio" name="pImage" value="img/main/9.jpg"><img alt="" src="img/thumbs/9.jpg">									</td>

								</tr>
								
								<tr>
									<td><label>Board</label></td>


									<td><select class="form-control" required name="pBoard">
											<%
												for (String boardName : bList) {
											%>
											<option><%=boardName%></option>
											<%
												}
											%>
									</select></td>
								</tr>
								<tr>
									<td><label>Description</label></td>
									<td><textarea class="form-control" class="span4"
											name="pDesc" required placholder="Description to the Board"></textarea></td>
								</tr>
								
								
							</table>



						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="TackIT">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>