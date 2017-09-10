package fr.epf.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.EmailDAO;
import fr.epf.models.Email;

/**
 * Servlet implementation class NewsletterServlet
 */
@WebServlet("/newsletter")
public class NewsletterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Inject
    private EmailDAO eMailDao;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Email> mailList = eMailDao.findAll();
		if(!mailList.isEmpty()) {
			request.setAttribute("subject", mailList.get(0).getSubject());
			request.setAttribute("content", mailList.get(0).getContent());
		}
		request.getRequestDispatcher("WEB-INF/newsletter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
