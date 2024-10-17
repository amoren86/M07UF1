package cat.institutmarianao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import cat.institutmarianao.ejb.LibraryLocal;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBAccessException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/libraryServlet" })
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private LibraryLocal library;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Library Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Test Library Servlet</h1>");
			out.println("<p>User: " + request.getUserPrincipal() + "</p>");
			if (request.isUserInRole("librarian")) {
				out.println("<p>" + library.catalog("java") + "</p>");
				out.println("<p>" + library.checkAvailability("php") + "</p>");
			}
			if (request.isUserInRole("user")) {
				out.println("<p>" + library.checkAvailability("java") + "</p>");
			}
			try {
				if (library.borrow("java")) {
					out.println("<p>This text is never shown</p>");
				}
			} catch (EJBAccessException e) {
				out.println("<p>Borrow is not allowed</p>");

			}
			out.println("</body>");
			out.println("</html>");
		}
	}
}