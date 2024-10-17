package cat.institutmarianao.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HiddenFieldServlet1", urlPatterns = { "/hiddenFieldServlet1" })
public class HiddenFieldServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Hidden Field Servlet </title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Now we are going to save the username in the form</h1>");

			String username = request.getParameter("username");
			out.print("Welcome " + username);

			out.print("<form action=\"hiddenFieldServlet2\" method=\"post\">");
			out.print("<input type=\"hidden\" name=\"hiddenName\" value=\"" + username + "\">");
			out.print("<input type=\"submit\" value=\"go\">");
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