package com.tackit.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tackit.DTO.User;
import com.tackit.services.LoginMaster;

/**
 * Servlet implementation class Signup
 */

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//Navigate to new user from login page
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User userInfo = new User();
		userInfo.setGenreList(new LoginMaster().getGenreList());
		HttpSession session = request.getSession();
		session.setAttribute("error", "");
		session.setAttribute("userInfo", userInfo);
		response.sendRedirect("NewUser.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//Process the user details and then navigate to dashboard page
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User userInfo = (User) session.getAttribute("userInfo");

		String firstName = (String) request.getParameter("fName");
		String lastName = (String) request.getParameter("lName");
		String email = (String) request.getParameter("eMail");
		String password = (String) request.getParameter("passwd");
		String[] genArray = null;
		if (request.getParameterValues("genreList") != null) {
			genArray = (String[]) request.getParameterValues("genreList");
			System.out.println(genArray.length);
		}

		LoginMaster lMaster = new LoginMaster();

		if (genArray != null)
			System.out.println(genArray.length);

		if (genArray != null && genArray.length > 0) {
			boolean result=false; 
			result= lMaster.checkUname(email);
			if (result) {
				session.setAttribute("fName", firstName);
				session.setAttribute("lName", lastName);
				session.setAttribute("eMail", "");
				session.setAttribute("passwd", password);
				session.setAttribute("error",
						"This email id is already under use!!!!!");
				response.sendRedirect("NewUser.jsp");
			} else {
				userInfo.setfName(firstName);
				userInfo.setlName(lastName);
				userInfo.setuName(email);
				userInfo.setuPasswd(password);
				List<String> genreList = new ArrayList<String>();
				for (String gen : genArray) {
					genreList.add(gen);
				}
				userInfo.setGenre(genreList);
				userInfo = lMaster.createUser(userInfo);
				session.setAttribute("userInfo", userInfo);
				session.setAttribute("error", "");
				response.sendRedirect("Dashboard.jsp");
			}
		} else {

			try {
				System.out.println("Reached hereodhnflvbfpknvpn	");
				session.setAttribute("userInfo", userInfo);
				session.setAttribute("error", "Please select one genre!!!");
				response.sendRedirect("NewUser.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
