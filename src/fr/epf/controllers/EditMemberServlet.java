package fr.epf.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.EmployeeDAO;
import fr.epf.models.Employee;

/**
 * Servlet implementation class EditMemberServlet
 */
@WebServlet("/edit_member")
public class EditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private EmployeeDAO employeeDao;

	public EditMemberServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");

		if(employee == null){
			response.sendRedirect("connection");
		}
		request.getRequestDispatcher("WEB-INF/edit_member.jsp").forward(request, response);
	}
	
	// Edit the selected employee
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = null;
		if (request.getParameter("action").equals("call")) {
			employee = employeeDao.findOne(Long.parseLong(request.getParameter("id")));
			request.setAttribute("employee", employee);
			if (employee.getAdminPriviledge() == 1) {
				request.setAttribute("isAdmin", "checked");
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(employee.getBirth());
			cal.add(Calendar.MONTH, 1); 
			request.setAttribute("employeeBirth",
					cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));
			request.getRequestDispatcher("/WEB-INF/edit_member.jsp").forward(request, response);

		} else if (request.getParameter("action").equals("save")) {
			employee = employeeDao.findOne(Long.parseLong(request.getParameter("id")));
			request.setAttribute("employee", employee);

			try {
				employee = parseEmployee(request);
				employeeDao.update(employee);
				request.setAttribute("error", "User updated");
			} catch (ParseException e) {
				e.printStackTrace();
				request.setAttribute("error", "Failed to parse date");
			}
			request.getRequestDispatcher("/WEB-INF/edit_member.jsp").forward(request, response);
		} else {
			response.sendRedirect("admin");
		}

	}

	// Retrieve the employee informations to edit them
	private Employee parseEmployee(HttpServletRequest request) throws ParseException {
		String login = ((Employee) request.getAttribute("employee")).getLogin();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Date date = ((Employee) request.getAttribute("employee")).getBirth();

		String string = request.getParameter("birth");
		if (string != "") {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(string);
		} else
			date = ((Employee) request.getAttribute("employee")).getBirth();

		if (request.getParameter("admin") != null) {
			return new Employee(name, email, date, login, password, 1);
		} else
			return new Employee(name, email, date, login, password, 0);
	}

}
