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
import fr.epf.models.MOTM;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	int totalCounter;
	int level1Counter;
	int level2Counter;
	int level3Counter;
	int level4Counter;
	int level5Counter;
	
	@Inject
	private MOTMDAO motmDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		retrievePublicRecentComments(request, response);

		retrieveMOTMCounters(request, response);

		determineAverage(request,response);
		
		request.getRequestDispatcher("WEB-INF/dashboard.jsp").forward(request, response);
	}

	private void retrievePublicRecentComments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MOTM> motmList = motmDAO.findRecentPublicComment();
		MOTM motm1 = new MOTM();
		MOTM motm2 = new MOTM();
		MOTM motm3 = new MOTM();
		MOTM motm4 = new MOTM();
		
		if(motmList.size()>=4){
			motm1 = motmList.get(0);
			motm2 = motmList.get(1);
			motm3 = motmList.get(2);
			motm4 = motmList.get(3);
		}
		String motm1Img = "img/" + motm1.getLevel() + ".png";
		request.getSession().setAttribute("motm1Img", motm1Img);
		request.getSession().setAttribute("motm1", motm1.getComment());

		String motm2Img = "img/" + motm2.getLevel() + ".png";
		request.getSession().setAttribute("motm2Img", motm2Img);
		request.getSession().setAttribute("motm2", motm2.getComment());

		String motm3Img = "img/" + motm3.getLevel() + ".png";
		request.getSession().setAttribute("motm3Img", motm3Img);
		request.getSession().setAttribute("motm3", motm3.getComment());

		String motm4Img = "img/" + motm4.getLevel() + ".png";
		request.getSession().setAttribute("motm4Img", motm4Img);
		request.getSession().setAttribute("motm4", motm4.getComment());
	}
	
	private void retrieveMOTMCounters(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		totalCounter = motmDAO.dataCount();
		level1Counter = motmDAO.levelCount(1);
		level2Counter = motmDAO.levelCount(2);
		level3Counter = motmDAO.levelCount(3);
		level4Counter = motmDAO.levelCount(4);
		level5Counter = motmDAO.levelCount(5);
		
		request.getSession().setAttribute("level1Counter", level1Counter);
		request.getSession().setAttribute("level2Counter", level2Counter);
		request.getSession().setAttribute("level3Counter", level3Counter);
		request.getSession().setAttribute("level4Counter", level4Counter);
		request.getSession().setAttribute("level5Counter", level5Counter);

		request.getSession().setAttribute("level1Total",
				String.format("%.2f", ((float) level1Counter / (float) totalCounter) * 100) + "%");
		request.getSession().setAttribute("level2Total",
				String.format("%.2f", ((float) level2Counter / (float) totalCounter) * 100) + "%");
		request.getSession().setAttribute("level3Total",
				String.format("%.2f", ((float) level3Counter / (float) totalCounter) * 100) + "%");
		request.getSession().setAttribute("level4Total",
				String.format("%.2f", ((float) level4Counter / (float) totalCounter) * 100) + "%");
		request.getSession().setAttribute("level5Total",
				String.format("%.2f", ((float) level5Counter / (float) totalCounter) * 100) + "%");
	}
	
	private void determineAverage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String average = String.format("%.2f",
				(float) (level1Counter + 2 * level2Counter + 3 * level3Counter + 4 * level4Counter + 5 * level5Counter)
						/ (float) totalCounter);

		String avgImg = "img/" + Math.round(Float.valueOf(average)) + ".png";

		request.getSession().setAttribute("average", average);
		request.getSession().setAttribute("avgImg", avgImg);
	}
}