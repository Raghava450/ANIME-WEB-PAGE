package com.company.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.company.dao.User;
import com.company.dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDaoImpl userDao =new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
			 public registerservlet() {
	       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");

	        User user = new User();
	        user.setUsername(username);
	        user.setEmail(email);
	        user.setPassword(password);

	      
			//UserDao userDao = new UserDaoImpl();
	        if (userDao.addUser(user)) {
	            response.sendRedirect("login.jsp?registration=success");
	        } else {
	            response.sendRedirect("register.jsp?error=1");
	        }
	}

}
