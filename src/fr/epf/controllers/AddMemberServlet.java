package fr.epf.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	// Empty constructor to be called on requests
    public AddMemberServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");

		if(employee == null){
			response.sendRedirect("connection");
		}
		request.getRequestDispatcher("WEB-INF/add_member.jsp").forward(request, response);
	}

	// Add a member to the database
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = parseEmployee(request);
		
		List<Employee> employeList = employeeDao.findSome(employee.getLogin());

		if(employeList.size() == 0 && employee.getLogin() != null && employee.getPass() != null){
			employeeDao.save(employee);
			request.setAttribute("error", "User added");
		} else{
			request.setAttribute("error", "Wrong data");
		}

		request.getRequestDispatcher("/WEB-INF/add_member.jsp").forward(request, response);
	}
	
	private Employee parseEmployee(HttpServletRequest request){
		String name = request.getParameter("name");
		String mail = request.getParameter("email");
		String stringDate = request.getParameter("date");
		System.out.println(stringDate);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = null;
		try {
		    date = df.parse(stringDate);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		if(request.getParameter("admin")!= null) {
			return new Employee(name, mail, date, login, password, 1);
		}else return new Employee(name, mail, date, login, password, 0);
		
	}

}
