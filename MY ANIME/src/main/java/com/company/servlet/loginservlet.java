package com.company.servlet;

import java.io.IOException;

import com.company.dao.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDaoImpl userDao = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if (userDao.isValidUser(username, password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username);
	            response.sendRedirect("welcome.jsp");
	            //System.out.println("Hi - "+username);
	        } else {
	            response.sendRedirect("login.jsp?error=1");
	        	System.out.println("Error A gya");
	        }
    }
}
