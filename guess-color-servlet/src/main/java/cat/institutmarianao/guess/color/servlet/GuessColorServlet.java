package cat.institutmarianao.guess.color.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuessColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String initColor;

	@Override
	public void init() throws ServletException {
		// S'ha configurat un paràmetre que conté el color a endevinar:
		initColor = getServletConfig().getInitParameter("color");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Guess the color</title>");
			out.println("</head>");
			out.println("<body>");

			String result = "Sorry, you lost!";

			// L'usuari ha seleccionat un color i ho ha enviat.
			String paramColor = request.getParameter("color");

			if (initColor.equalsIgnoreCase(paramColor)) {
				result = "Congratulations! You guess the color";
			}

			out.println("<h1>" + result + "</h1>");
			out.println("<a href='GuessColor.html'>Try again</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
