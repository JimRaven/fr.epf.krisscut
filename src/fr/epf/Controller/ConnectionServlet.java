package fr.epf.Controller;

import java.io.IOException;
import java.util.Iterator;
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
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private EmployeDAO employeDao;

    public ConnectionServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employe employe = parseEmploye(request);
		
		List<Object> employeList = employeDao.findSome(employe.getLogin());
		Iterator<Object> employeItr = employeList.iterator();
		
		while(employeItr.hasNext()) {
			Object[] employeObj = (Object[]) employeItr.next();
			
			if(employe.getPass().equals(employeObj[1])) {
				employe.setId((Long) employeObj[2]);
				employe.setPass("********");
				employe.setAdminPriviledge((Boolean) employeObj[3]);
				
				request.getSession().setAttribute("employe", employe);
				
				if((Boolean) employeObj[3]) {
					response.sendRedirect("admin");
				}else {
					response.sendRedirect("employe");
				}
			}
		}
		
		request.setAttribute("error", "Wrong login");
		request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	}
	
	private Employe parseEmploye(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		return new Employe(null, null, null, login, password, null);
		
	}

}
