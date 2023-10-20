package cat.institutmarianao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cat.institutmarianao.ejb.PostBeanLocal;

@WebServlet(name = "PostServlet", urlPatterns = { "/PostServlet" })
public class PostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private PostBeanLocal validator;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Validator Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>EJB validation</h1>");

			String mail = request.getParameter("mail");
			if (validator.isValidEmail(mail)) {
				out.println("<p>The e-mail <q><cite>" + mail + "</cite></q> is valid</p>");
			} else {
				out.println("<p>The e-mail <q><cite>" + mail + "</cite></q> is not valid</p>");
			}

			String age = request.getParameter("age");
			if (validator.isValidAge(age)) {
				out.println("<p>You are <q><cite>" + age
						+ "</cite></q> years old and you are allowed to write a message</p>");
			} else {
				out.println("<p>You are <q><cite>" + age
						+ "</cite></q> years old and you must be older than 18 to write a message</p>");
			}

			String postMessage = request.getParameter("postMessage");
			if (validator.isValidPost(postMessage)) {
				out.println("<p>The message <q><cite>" + postMessage + "</cite></q> is valid</p>");
			} else {
				out.println("<p>The message <q><cite>" + postMessage
						+ "</cite></q> is not valid. It must have at most 150 characters</p>");
			}

			out.println("</body>");
			out.println("</html>");
		}
	}
}