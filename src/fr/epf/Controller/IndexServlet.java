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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/admin")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EmployeDAO employeDao;
	
    public IndexServlet() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((Employe) request.getSession().getAttribute("employe") == null){
			response.sendRedirect("connection");
		}
		Employe employe = (Employe) request.getSession().getAttribute("employe");
		
		if(!employe.getAdminPriviledge())
			response.sendRedirect("employe");

		List<Employe> employeList = employeDao.findAll();
		
		request.setAttribute("employeList", employeList);
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
}
