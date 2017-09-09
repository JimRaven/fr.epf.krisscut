package fr.epf.controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.EmployeeDAO;
import fr.epf.models.Employee;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private EmployeeDAO employeeDao;

    public ConnectionServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = parseEmployee(request);
		
		employeeDao.save(employee);
		
		List<Object> employeeList = employeeDao.findSome(employee.getLogin());
		Iterator<Object> employeeItr = employeeList.iterator();
		
		while(employeeItr.hasNext()) {
			Object[] employeeObj = (Object[]) employeeItr.next();
			
			if(employee.getPass().equals(employeeObj[1])) {
				employee.setId((Long) employeeObj[2]);
				employee.setPass("********");
				employee.setAdminPriviledge((Boolean) employeeObj[3]);
				
				request.getSession().setAttribute("employee", employee);
				
				if((Boolean) employeeObj[3]) {
					response.sendRedirect("dashboard");
				}else {
					response.sendRedirect("employee");
				}
			}
		}
		
		request.setAttribute("error", "Wrong login");
		request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	}
	
	private Employee parseEmployee(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		return new Employee(null, null, null, login, password, true);
		
	}

}
