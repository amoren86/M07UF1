package cat.institutmarianao.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CookiesServlet2", urlPatterns = { "/cookiesServlet2" })
public class CookiesServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Cookies Servlet 2</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Access to the cookie to read the username</h1>");
			Cookie[] cookies = request.getCookies();
			Cookie userCookie = findCookie(cookies, "user");
			if (userCookie != null) {
				// TODO - B64Decode value from cookiec after get
				out.print("Hello " + userCookie.getValue() + "!");
			} else {
				out.print("Cookie not found!");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}

	private Cookie findCookie(Cookie[] cookies, String cookieName) {
		for (Cookie cookie : cookies) {
			if (cookieName.contentEquals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}
}