package com.tackit.servlet;

import java.io.IOException;
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
public class BoardProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardProcessor() {
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
		String uId=request.getParameter("uId");
		String bName=request.getParameter("bName");
		userInfo.setBoardPinList(new PinManager().populateUserPinList(uId));
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
		session.setAttribute("bName",bName);
		session.setAttribute("userInfo",userInfo);
		response.sendRedirect("BoardView.jsp");
		
		
	}

}