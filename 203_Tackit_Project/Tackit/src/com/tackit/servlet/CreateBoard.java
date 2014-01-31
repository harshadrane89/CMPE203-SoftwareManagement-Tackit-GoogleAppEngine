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

/**
 * Servlet implementation class CreateBoard
 */

public class CreateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//Dropdown creating  a new board
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("userInfo");
		
		BoardManager bManager=new BoardManager();
		
		Board ref=new Board();
		ref.setBoardName(request.getParameter("bName"));
		ref.setBoardDesc(request.getParameter("bDesc"));
		ref.setBoardGenre(request.getParameter("bGenre"));
		ref.setBoardType(Integer.parseInt(request.getParameter("bType")));
		ref=bManager.createBoard(ref, user.getUserId());
		user.getFollowedBoardList().add(ref);
		user.getBoardID().put(ref.getBoardName(), ref.getBoardId()+"");
		response.sendRedirect("Dashboard.jsp");
	}

}
