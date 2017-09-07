package fr.epf.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("liveUserCount", getServletContext().getAttribute("liveUserCount"));
		request.getRequestDispatcher("WEB-INF/dashboard.jsp").forward(request, response);
	}
	
	protected void test() {
		
	}
}