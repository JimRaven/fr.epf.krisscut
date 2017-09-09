package fr.epf.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.EmployeeDAO;
import fr.epf.models.Employee;

@WebServlet("/")
public class DefaultRedirector extends HttpServlet {
	
	@Inject
	private EmployeeDAO employeeDao;
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		employeeDao.createDefault();
		
		Employee user = (Employee) request.getSession().getAttribute("employee");
		
		if(user == null){
			response.sendRedirect("connection");
		}else if(user.getAdminPriviledge()==1) {
			response.sendRedirect("admin");
		}else {
			response.sendRedirect("employee");
		}
	}

}
