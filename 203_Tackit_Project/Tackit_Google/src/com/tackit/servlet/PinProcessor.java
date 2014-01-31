package com.tackit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tackit.DTO.Pin;
import com.tackit.DTO.User;
import com.tackit.services.PinManager;

/**
 * Servlet implementation class PinProcessor
 */

public class PinProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PinProcessor() {
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
		
		Pin pinObj = new Pin();
		
		pinObj.setPinUid(userInfo.getUserId());
		
		String pBoard = request.getParameter("pBoard");
		pinObj.setPinBid(userInfo.getBoardID().get(pBoard));
		
		pinObj.setPinLink(request.getParameter("pLink"));
		pinObj.setImgLocation(request.getParameter("pImage"));
		pinObj.setPinDescription(request.getParameter("pDesc"));
		pinObj.setPinName(request.getParameter("pName"));
		pinObj.setpGenre(request.getParameter("pGenre"));
		new PinManager().createNewPin(pinObj);
		
		response.sendRedirect("Dashboard.jsp");
	}

}
