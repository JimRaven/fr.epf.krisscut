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
@WebServlet("/edit_user_motm")
public class EditUserMOTMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private MOTMDAO motmDAO;

	@Inject
	private MOTMDescDAO MOTMDescDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserMOTMServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("employee");

		if (employee == null) {
			response.sendRedirect("connection");
		}
		List<MOTMDesc> MOTMDescList = MOTMDescDao.findAll();

		MOTMDesc motmDesc = new MOTMDesc("");
		if (!MOTMDescList.isEmpty()) {
			motmDesc = MOTMDescList.get(0);
		}
		request.setAttribute("desc", motmDesc.getContent());
		request.getRequestDispatcher("WEB-INF/edit_user_motm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MOTM motm = null;
		if (request.getParameter("action").equals("call")) {
			motm = motmDAO.findOne(Long.parseLong(request.getParameter("id")));
			request.setAttribute("motm", motm);
			if (motm.getLevel() == 1) {
				request.setAttribute("isLevel1", "checked");
			} else if (motm.getLevel() == 2) {
				request.setAttribute("isLevel2", "checked");
			} else if (motm.getLevel() == 3) {
				request.setAttribute("isLevel3", "checked");
			} else if (motm.getLevel() == 4) {
				request.setAttribute("isLevel4", "checked");
			} else if (motm.getLevel() == 5) {
				request.setAttribute("isLevel5", "checked");
			}
			if (motm.getVisible() == 1) {
				request.setAttribute("isVisible", "checked");
			}
			request.getRequestDispatcher("/WEB-INF/edit_user_motm.jsp").forward(request, response);

		} else if (request.getParameter("action").equals("save")) {
			motm = motmDAO.findOne(Long.parseLong(request.getParameter("id")));
			motm.setComment(request.getParameter("comment"));
			motm.setLevel(Integer.parseInt(request.getParameter("note")));
			motmDAO.update(motm);
			request.setAttribute("error", "Answer updated");
			response.sendRedirect("employee");
		} else {
			response.sendRedirect("employee");
		}

	}

}
