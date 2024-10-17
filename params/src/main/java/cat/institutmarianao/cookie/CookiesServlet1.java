package cat.institutmarianao.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CookiesServlet1", urlPatterns = { "/cookiesServlet1" })
public class CookiesServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Cookies Servlet 1</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Now we are going to save the cookie in your browser</h1>");

			String username = request.getParameter("username");
			out.print("Welcome " + username);

			// TODO - B64Encode username before create Cookie
			Cookie cookie = new Cookie("user", username);
			response.addCookie(cookie);

			out.print("<form action='cookiesServlet2'>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");

			out.println("</body>");
			out.println("</html>");
		}
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
