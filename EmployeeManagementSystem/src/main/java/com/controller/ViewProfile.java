package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Employee;

import com.dao.EmployeeDAO;

/**
 * Servlet implementation class ViewAllEmployees
 */
@WebServlet("/viewprofile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(true);
		
		String email = (String) session.getAttribute("email");
		
		EmployeeDAO dao = new EmployeeDAO();
		try {
		
			 Employee employee = dao.getProfile(email);
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("viewprofile.jsp");
			 request.setAttribute("employee", employee);
			 dispatcher.forward(request, response);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
