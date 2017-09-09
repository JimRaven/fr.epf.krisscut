package fr.epf.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.dao.EmployeeDAO;
import fr.epf.dao.MOTMDAO;
import fr.epf.models.Employee;
import fr.epf.models.MOTM;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int totalCounter;
	int level1Counter;
	int level2Counter;
	int level3Counter;
	int level4Counter;
	int level5Counter;
	
	@Inject
	private MOTMDAO motmDAO;
	private EmployeeDAO employeeDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		retrievePublicRecentComments(request, response);

		retrieveMOTMCounters(request, response);

		determineAverage(request,response);

		Employee employee = (Employee) request.getSession().getAttribute("employee");

		if((Employee) request.getSession().getAttribute("employee") == null){
			response.sendRedirect("connection");
		}

    Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		if(!employee.getAdminPriviledge())
			response.sendRedirect("employee");

		List<Employe> employeList = employeDao.findAll();
		
		request.setAttribute("employeList", employeList);
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	private void retrievePublicRecentComments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MOTM> motmList = motmDAO.findRecentPublicComment();

		MOTM motm1 = motmList.get(0);
		String motm1Img = "img/" + motm1.getLevel() + ".png";
		request.getSession().setAttribute("motm1Img", motm1Img);
		request.getSession().setAttribute("motm1", motm1.getComment());

		MOTM motm2 = motmList.get(1);
		String motm2Img = "img/" + motm2.getLevel() + ".png";
		request.getSession().setAttribute("motm2Img", motm2Img);
		request.getSession().setAttribute("motm2", motm2.getComment());

		MOTM motm3 = motmList.get(2);
		String motm3Img = "img/" + motm3.getLevel() + ".png";
		request.getSession().setAttribute("motm3Img", motm3Img);
		request.getSession().setAttribute("motm3", motm3.getComment());

		MOTM motm4 = motmList.get(3);
		String motm4Img = "img/" + motm4.getLevel() + ".png";
		request.getSession().setAttribute("motm4Img", motm4Img);
		request.getSession().setAttribute("motm4", motm4.getComment());
	}
	
	private void retrieveMOTMCounters(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Long> totalCount = motmDAO.dataCount();
		totalCounter = totalCount.get(0).intValue();

		List<Long> level1Count = motmDAO.levelCount(1);
		level1Counter = level1Count.get(0).intValue();
		List<Long> level2Count = motmDAO.levelCount(2);
		level2Counter = level2Count.get(0).intValue();
		List<Long> level3Count = motmDAO.levelCount(3);
		level3Counter = level3Count.get(0).intValue();
		List<Long> level4Count = motmDAO.levelCount(4);
		level4Counter = level4Count.get(0).intValue();
		List<Long> level5Count = motmDAO.levelCount(5);
		level5Counter = level5Count.get(0).intValue();
		
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