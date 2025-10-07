package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;

/**
 * Servlet implementation class SaveUser
 */
@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("findAll");
		
		EmployeeDAO dao = new EmployeeDAO();
		
		try {
			boolean status = dao.deleteEmployee(Integer.parseInt(request.getParameter("id")));
			if(status) {
				dao.commit();
				request.setAttribute("status", "Updated Successfully.....");
				dispatcher.forward(request, response);
			}
			else {
				dao.rollback();
				request.setAttribute("status", "Updation Failed.....");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
