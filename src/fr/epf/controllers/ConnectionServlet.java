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

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private EmployeeDAO employeeDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	}

	// On "login" button clicked, verify the user presence in the database and his status (employee or administrator),
	// create a session and redirect him to his homepage.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = employeeDao.findFirstByLoginAndPassword(request.getParameter("login"), request.getParameter("password"));
		
		if(employee!=null) {
			request.getSession().setAttribute("employee", employee);
			if(employee.getAdminPriviledge()==1) {
				response.sendRedirect("admin");
			}else response.sendRedirect("employee");
		}
		request.setAttribute("error", "Wrong login or password");
		response.sendRedirect("connection");
	}

}
