package cat.institutmarianao.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HiddenFieldServlet2", urlPatterns = { "/hiddenFieldServlet2" })
public class HiddenFieldServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>HiddenField Servlet 2</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Access to the hidden field to read the username</h1>");

			String hiddenName = request.getParameter("hiddenName");

			if (hiddenName != null) {
				out.print("Hello " + hiddenName + "!");
			} else {
				out.print("Hidden param not found!");
			}
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