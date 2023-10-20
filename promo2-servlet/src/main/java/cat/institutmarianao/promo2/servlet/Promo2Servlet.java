package cat.institutmarianao.promo2.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Promo2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Set<String> ip;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ip = new HashSet<>();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestIp = request.getRemoteAddr();

		// html forward
		RequestDispatcher rs;

		if (ip.contains(requestIp)) {

			// html redirect - rest of times
//			response.sendRedirect("rest_times.html");
			// html forward - rest of times
			rs = request.getRequestDispatcher("rest_times.html");
		} else {

			// html redirect - first time
//			response.sendRedirect("first_time.html");
			// html forward - rest of times
			rs = request.getRequestDispatcher("first_time.html");

			ip.add(requestIp);
		}
		rs.forward(request, response);

	}
}