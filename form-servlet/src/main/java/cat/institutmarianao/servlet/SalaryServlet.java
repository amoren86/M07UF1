package cat.institutmarianao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SalaryServlet", urlPatterns = { "/SalaryServlet" })
public class SalaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Form Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Received data from the form</h1>");

			int gross = Integer.parseInt(request.getParameter("salary"));
			out.println("<p>Gross salary: " + gross + "</p>");

			int children = Integer.parseInt(request.getParameter("children"));
			out.println("<p>Childrens: " + children + "</p>");

			out.println("<h1>Net salary calculation:</h1>");
			int withholding = 21 - 5 * children;

			// Fórmula per a calcular la retenció: neto = brut*(retenció/100);
			int net = gross - (int) (gross * (withholding / 100.0f));

			out.println("<p>You have a tax withholding of " + withholding + " percent</p>");
			out.println("<p>Your net salary is " + net + " euros</p>");
			out.println("<a href='salary.html'> Go back </a>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}