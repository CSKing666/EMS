package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Employee;

import com.dao.EmployeeDAO;

/**
 * Servlet implementation class ViewAllEmployees
 */
@WebServlet("/findByEmail")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("email");
		
		EmployeeDAO dao = new EmployeeDAO();
		try {
		
			 Employee employee = dao.searchEmployee(email);
			 
			 if(employee.getId() == 0) {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
				 request.setAttribute("status", "Employee Not Found..........");
				 dispatcher.forward(request, response);
			 }
			 
			 else {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("viewemp.jsp");
				 request.setAttribute("employee", employee);
				 dispatcher.forward(request, response);				 
			 }
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
