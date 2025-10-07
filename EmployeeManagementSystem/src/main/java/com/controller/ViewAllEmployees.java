package com.controller;

import java.util.List;
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
@WebServlet("/findAll")
public class ViewAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		EmployeeDAO dao = new EmployeeDAO();
		try {
			List<Employee> empList= dao.getAllEmployees();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewemps.jsp");
			request.setAttribute("empList", empList);
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
