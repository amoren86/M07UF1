package cat.institutmarianao.promo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int visits;

	private int num;
	private String promoUrl;
	private Set<String> ip;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ip = new HashSet<>();
		num++;
		visits = 0;
		promoUrl = getServletConfig().getInitParameter("url");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Promo Servlet</title>");
			out.println("</head>");
			out.println("<body>");

			String requestIp = request.getRemoteAddr();

			if (ip.contains(requestIp)) {
				isNotFirstTime(out);
			} else {
				isFirstTime(requestIp, out);
			}

			visits++;

			out.println("<h5>This page has " + visits + " visits up to now</h5>");
			out.println("<h5>The init method has been called " + num + " times</h5>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	private void isNotFirstTime(PrintWriter out) {
		out.println("<h1>Thanks for comming to this page. You will see the promo no more</h1>");
	}

	private void isFirstTime(String requestIp, PrintWriter out) {

		ip.add(requestIp);

		out.println("<h1>Thats is your first access to this page. Welcome!</h1>");
		out.println("<p style='color:red;'>Access to promo clicking this link: </p>");
		out.println("<a href='" + promoUrl + "'>Promo web</a>");
	}
}