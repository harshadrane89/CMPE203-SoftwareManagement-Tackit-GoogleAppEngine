<%@page import="com.tackit.DTO.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.tackit.DTO.Pin"%>
<%@page import="java.util.ArrayList"%>
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
	<div align="right">
<form action="SBoard" method="get">
		<input type="submit" value="Follow Board" class="btn btn  btn-success">
	</form>
</div>
	<%
		User userObj = (User) session.getAttribute("userInfo");
		boolean feed = userObj.getBoardPinList().isEmpty();
		List<String> bbList = new ArrayList<String>();
		
		for (Board board : userObj.getBoardList()) {
			bbList.add(board.getBoardName());
		}
		for (Board board : userObj.getFollowedBoardList()) {
			bbList.add(board.getBoardName());
		}
		
	%>
	

	<%-- 	 --%>
	<center><h2><%=session.getAttribute("bName")%></h2>
	<br>
	
	</center>
	<br>
	<br>
	<%
		if (!feed) {
			ArrayList<Pin> pFeedList = (ArrayList<Pin>) userObj
					.getBoardPinList();
			int i;
			int j;
	%>
	<table class="table table-bordered">
		<%
			for (i = 0; i < pFeedList.size(); i++) {
		%>
		<tr>

			<%
				for (j = i; j < i + 4; j++) {
							if (j == pFeedList.size()) {

								for (int k = j; k < i + 4; k++) {
			%>
			<td></td>
			<%
				}
								break;
							} else {
			%>
			<td>
			<center>
			<h4><%=pFeedList.get(i).getPinName()%></h4>
			<a href="<%=pFeedList.get(j).getPinLink()%>" target="_blank"><img
					alt="" src="<%=pFeedList.get(j).getImgLocation()%>"></a> 
					</center>	
					<br> <div align="left" style="color:#A8A8A8;">
					
				<%=pFeedList.get(j).getPinDescription()%><br> <a href="#<%=j%>"
				class="btn btn-danger" data-toggle="modal">TackIT</a> <br>
				</div>

				<div id="<%=j%>" class="modal fade" aria-hidden="false">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<center>
									<h2>TackIT</h2>
								</center>
							</div>
							<form class="form-horizontal" action="PinInfo" method="post">
								<div class="modal-body">
									<div class="container">
										<table cellpadding="10px" cellspacing="10px">
											<tr>
												<td><label>URL</label></td>
												<td><input class="form-control" 
													required="true" type="text" class="span4" 
													disabled="true" value="<%=pFeedList.get(j).getPinLink()%>">
													<input type="hidden"
													value="<%=j %>" name="pNo">
													<input type="hidden"
													value="<%=pFeedList.get(j).getPinLink()%>" name="pLink">
													<input type="hidden"
													value="<%=pFeedList.get(j).getPinName()%>" name="pName">
													<input type="hidden"
													value="<%=pFeedList.get(j).getImgLocation()%>" name="pImage">
													<input type="hidden"
													value="<%=pFeedList.get(j).getpGenre()%>" name="pGenre">
												</td>
											</tr>

											<tr>
												<td><label>Board</label></td>


												<td><select class="form-control" required name="pBoard" >
														<%
															for (String boardName : bbList) {
														%>
														<option><%=boardName%></option>
														<%
															}
														%>
												</select></td>
											</tr>
											<tr>
												<td><label>Description</label></td>
												<td><textarea class="form-control" class="span4" autofocus
														name="pDesc" required placholder="Description to the Pin"></textarea></td>
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
		
				</td>
			<%
				}
						}
						i = j - 1;
			%>
		</tr>
		<%
			}
		%>
	</table>


	<%
		} else {
	%>
	<h3>
		<%="No feeds available"%>
	</h3>
	<%
		}
	%>
	
</body>
</html>