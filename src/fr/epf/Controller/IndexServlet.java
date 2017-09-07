package fr.epf.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.Model.Employe;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/admin")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public IndexServlet() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employe employe = (Employe) request.getSession().getAttribute("employe");
		
		if((Employe) request.getSession().getAttribute("employe") == null){
			response.sendRedirect("");
		}
		
		if(employe.getAdminPriviledge()) {
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("employe");
		}
	}
}
