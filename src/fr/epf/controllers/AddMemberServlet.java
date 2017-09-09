package fr.epf.controllers;

import java.io.IOException;
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
 * Servlet implementation class add_member
 */
@WebServlet("/add_member")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EmployeeDAO employeeDao;

    public AddMemberServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/add_member.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = parseEmployee(request);
		
		List<Employee> employeeList = employeeDao.findSome(employee.getLogin());

		if(employeeList.size() == 0 && employee.getLogin() != null && employee.getPass() != null){
			employeeDao.save(employee);
			request.setAttribute("error", "User added");
		} else{
			request.setAttribute("error", "Wrong login");
		}

		request.getRequestDispatcher("/WEB-INF/add_member.jsp").forward(request, response);
	}
	
	private Employee parseEmployee(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		return new Employee(null, null, null, login, password, 0);
		
	}

}
