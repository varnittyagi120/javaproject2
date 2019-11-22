package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		printWriter.print(username);
		/*if (username.equals("varnit") && password.equals("Varnit@13")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WelcomeServlet");
			requestDispatcher.forward(request, response);
		} else {
			printWriter.println("<!DOCTYPE html>");
			printWriter.println("<html><body>");
			printWriter.println("<script>");
			printWriter.println("alert('Sorry wrong username or password')");
			printWriter.println("</script>");
			printWriter.println("</body></html>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			requestDispatcher.forward(request, response);
			//response.sendRedirect("http://www.google.com/#q="+username);
		}*/
	}

}
