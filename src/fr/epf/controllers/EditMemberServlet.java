package fr.epf.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = null;
		if(request.getParameter("action").equals("call")) {
			employee = employeeDao.findOne(Long.parseLong(request.getParameter("id")));
			request.setAttribute("employe", employee);
			
			request.getRequestDispatcher("/WEB-INF/edit_member.jsp").forward(request, response);
			
		} else if (request.getParameter("action").equals("save")) {
			employee = employeeDao.findOne(Long.parseLong(request.getParameter("id")));
			request.setAttribute("employe", employee);
			
			try {
				employee = parseEmployee(request);
				employeeDao.update(employee);
				request.setAttribute("error", "user updated");
			} catch (ParseException e) {
				e.printStackTrace();
				request.setAttribute("error", "couldn't parse date");
			}
			request.getRequestDispatcher("/WEB-INF/edit_member.jsp").forward(request, response);
		} else {
			response.sendRedirect("admin");
		}

	}
	
	private Employee parseEmployee(HttpServletRequest request) throws ParseException {
		String login = ((Employee) request.getAttribute("employee")).getLogin();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Date date = ((Employee) request.getAttribute("employee")).getBirth();

		String string = request.getParameter("birth");
		if(string != "")
			date = new SimpleDateFormat("yyyy-MM-dd").parse(string);
		else date = ((Employee) request.getAttribute("employee")).getBirth();
		
		return new Employee(name, email, date, login, password, 0);
	}

}
