package cat.institutmarianao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import cat.institutmarianao.ejb.Post2BeanLocal;
import jakarta.annotation.Resource;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@WebServlet(name = "Post2Servlet", urlPatterns = { "/Post2Servlet" })
public class Post2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource
	private Validator validator;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Validator 2 Servlet</title>");
			out.println("</head>");
			out.println("<body>");

			String message = request.getParameter("postMessage");
			String mail = request.getParameter("mail");
			String age = request.getParameter("age");

			Post2BeanLocal bean = (Post2BeanLocal) new InitialContext().lookup("java:global/form-servlet/Post2Bean");

			bean.setMessage(message);
			bean.setEmail(mail);
			bean.setAge(age);

			out.println("<h1>Submitted data from form</h1>");
			out.println("<p>Email: <q><cite>" + bean.getEmail() + "</cite></q></p>");
			out.println("<p>Age: <q><cite>" + bean.getAge() + "</cite></q></p>");
			out.println("<p>Message: <q><cite>" + bean.getMessage() + "</cite></q></p>");

			out.println("<h1>Validations:</h1>");
			for (ConstraintViolation<Post2BeanLocal> c : validator.validate(bean)) {
				out.println("<p>" + c.getMessage() + "</p>");
			}

			out.println("</body>");
			out.println("</html>");
		} catch (NamingException ex) {
			Logger.getLogger(Post2BeanLocal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
