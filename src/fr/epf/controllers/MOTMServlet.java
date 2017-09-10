package fr.epf.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.MOTMDAO;
import fr.epf.dao.MOTMDescDAO;
import fr.epf.models.Employee;
import fr.epf.models.MOTM;
import fr.epf.models.MOTMDesc;

/**
 * Servlet implementation class MOTMServlet
 */
@WebServlet("/motm")
public class MOTMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MOTMDAO motmDAO;

	@Inject
	private MOTMDescDAO MOTMDescDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MOTMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MOTMDesc> MOTMDescList = MOTMDescDao.findAll();
		
		MOTMDesc motmDesc = new MOTMDesc("");
		if(!MOTMDescList.isEmpty()) {
			motmDesc = MOTMDescList.get(0);
		}
		request.setAttribute("desc", motmDesc.getContent());
		request.getRequestDispatcher("WEB-INF/motm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MOTM motm = parseMOTM(request);
		
		motmDAO.save(motm);
		response.sendRedirect("admin");
	}
	
	private MOTM parseMOTM(HttpServletRequest request) {
		Employee employee = (Employee)request.getSession().getAttribute("employee");
		int level = Integer.parseInt(request.getParameter("note"));
		String comment = request.getParameter("comment");
		int visibility = 0;
		if(request.getParameter("public")!= null) {
			visibility = 1;
		}
		return new MOTM(level,comment, visibility, employee.getLogin());
		
	}

}
