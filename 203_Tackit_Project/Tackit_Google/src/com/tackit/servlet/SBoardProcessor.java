package com.tackit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tackit.DTO.Board;
import com.tackit.DTO.User;
import com.tackit.services.BoardManager;
import com.tackit.services.PinManager;

/**
 * Servlet implementation class BoardProcessor
 */
public class SBoardProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SBoardProcessor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User userInfo = (User) session.getAttribute("userInfo");
		String bName=(String)session.getAttribute("bName");
		String bId=(String)session.getAttribute("sBId");
		List<Board> sBList=userInfo.getuBSuggestionList();
		int index=0;
		Board temp=null;
		for(int i=0;i<sBList.size();i++)
		{
			if(sBList.get(i).getBoardId()==Integer.parseInt(bId))
			{
				index=i;
				temp=sBList.get(i);
				break;
			}
		}
		
		new BoardManager().updateUserBoardMaster(userInfo.getUserId(),bId);
		sBList.remove(index);
		userInfo.setuBSuggestionList(sBList);
		userInfo.getFollowedBoardList().add(temp);
		userInfo.setBoardPinList(new PinManager().populateUserBoardPinList(bId));
		userInfo.getBoardID().put(temp.getBoardName(), bId);
		session.setAttribute("bName",bName);
		session.setAttribute("userInfo",userInfo);
		response.sendRedirect("BoardView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		User userInfo = (User) session.getAttribute("userInfo");
		String bId=request.getParameter("bId");
		String bName=request.getParameter("bName");
		userInfo.setBoardPinList(new PinManager().populateUserBoardPinList(bId));
		session.setAttribute("sBId",bId);
		session.setAttribute("bName",bName);
		session.setAttribute("userInfo",userInfo);
		response.sendRedirect("SuggestedBoardView.jsp");
		
		
	}

}
