package com.tackit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tackit.DTO.User;
import com.tackit.services.LoginMaster;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
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
	//Navigate to dashboard
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String uName=(String)request.getParameter("login");
		String uPasswd=(String)request.getParameter("passwd");
		System.out.println(uName+uPasswd);
		LoginMaster loginProcessor=new LoginMaster();
		boolean result=loginProcessor.validateUser(uName, uPasswd);
		if(!result)
		{
			User userInfo=loginProcessor.loginUser(uName, uPasswd);
			session.setAttribute("LError1","");
			session.setAttribute("userInfo", userInfo);
			response.sendRedirect("Dashboard.jsp");
		}
		else
		{
			session.setAttribute("LError1", "Please Enter A Valid UserName or Password");
			response.sendRedirect("Login.jsp");
		}
		
	}

}
