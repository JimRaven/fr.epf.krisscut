package fr.epf.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.EmailDAO;
import fr.epf.dao.MOTMDescDAO;
import fr.epf.models.Email;
import fr.epf.models.Employee;
import fr.epf.models.MOTMDesc;

/**
 * Servlet implementation class EditMOTMServlet
 */
@WebServlet("/edit_motm")
public class EditMOTMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EmailDAO eMailDao;
	@Inject
	private MOTMDescDAO MOTMDescDao;
	
    public EditMOTMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");

		if(employee == null){
			response.sendRedirect("connection");
		}
		request.getRequestDispatcher("WEB-INF/edit_motm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Email eMailSettings = parseEMail(request.getParameter("subject"),request.getParameter("email"));
		
		MOTMDesc motmDesc = new MOTMDesc(request.getParameter("desc").toString());
		
		eMailDao.save(eMailSettings);
		
		MOTMDescDao.save(motmDesc);
		
		response.sendRedirect("admin");
	}
	
	private Email parseEMail(String subject, String content) {
		return new Email(subject, content, null);
	}

}
