package fr.epf.Controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.DAO.EmployeDAO;
import fr.epf.Model.Employe;

/**
 * Servlet implementation class add_member
 */
@WebServlet("/add_member")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EmployeDAO employeDao;

    public AddMemberServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/add_member.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employe employe = parseEmploye(request);
		
		List<Object> employeList = employeDao.findSome(employe.getLogin());
		if(employeList.size() == 0 && employe.getLogin() != null){
			employeDao.save(employe);
		} else{
			request.setAttribute("error", "Wrong login");
		}

		request.getRequestDispatcher("/WEB-INF/add_member.jsp").forward(request, response);
	}
	
	private Employe parseEmploye(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		return new Employe(null, null, null, login, password, null);
		
	}

}
