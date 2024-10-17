package cat.institutmarianao.guess.color.servlet;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuessColor2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String initColor;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		initColor = config.getInitParameter("color");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// L'usuari ha seleccionat un color i ho ha enviat.
		String paramColor = request.getParameter("color");

		if (paramColor == null) {
			response.sendRedirect("guess_color_2.html");
		} else if (initColor.equalsIgnoreCase(paramColor)) {
			response.sendRedirect("win.html");
		} else {
			response.sendRedirect("loose.html");
		}
	}
}
