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
import com.model.Employee;
import com.model.Employee.Gender;

/**
 * Servlet implementation class SaveUser
 */
@WebServlet("/save")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Employee obj = new Employee();
		
		obj.setName(request.getParameter("name"));
		obj.setEmail(request.getParameter("email"));
		obj.setPassword(request.getParameter("password"));
		obj.setAge(Integer.parseInt(request.getParameter("age")));
		obj.setGender(Gender.valueOf(request.getParameter("gender")));
		obj.setMobile(request.getParameter("mobile"));
		obj.setDepartment(request.getParameter("department"));
		obj.setAddress(request.getParameter("address"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		
		EmployeeDAO dao = new EmployeeDAO();
		
		try {
			boolean status = dao.saveEmployee(obj);
			if(status) {
				dao.commit();
				request.setAttribute("status", "Registered Successfully.....");
				dispatcher.forward(request, response);
			}
			else {
				dao.rollback();
				request.setAttribute("status", "Registration Failed.....");
				dispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
