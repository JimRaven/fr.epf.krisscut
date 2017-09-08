package fr.epf.Controller;

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

import fr.epf.DAO.EmployeDAO;
import fr.epf.Model.Employe;

/**
 * Servlet implementation class EditMemberServlet
 */
@WebServlet("/edit_member")
public class EditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmployeDAO employeDao;
	
    public EditMemberServlet() {
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employe employe = null;
		if(request.getParameter("action").equals("call")) {
			employe = employeDao.findOne(Long.parseLong(request.getParameter("id")));
			request.setAttribute("employe", employe);
			
			request.getRequestDispatcher("/WEB-INF/edit_member.jsp").forward(request, response);
			
		} else if (request.getParameter("action").equals("save")) {
			employe = employeDao.findOne(Long.parseLong(request.getParameter("id")));
			request.setAttribute("employe", employe);
			
			try {
				employe = parseEmploye(request);
				employeDao.save(employe);
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
	
	private Employe parseEmploye(HttpServletRequest request) throws ParseException {
		String login = ((Employe) request.getAttribute("employe")).getLogin();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Date date = ((Employe) request.getAttribute("employe")).getBirth();

		String string = request.getParameter("birth");
		if(string != "")
			date = new SimpleDateFormat("yyyy-MM-dd").parse(string);
		else date = ((Employe) request.getAttribute("employe")).getBirth();

		return new Employe(name, email, date, login, password, false);
	}

}
