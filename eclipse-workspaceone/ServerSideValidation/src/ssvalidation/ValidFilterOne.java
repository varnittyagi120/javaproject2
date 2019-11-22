package ssvalidation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidFilterOne
 */
@WebServlet("/ValidFilterOne")
public class ValidFilterOne extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(fname);
        printWriter.print(lname);
        printWriter.print(password);
	}

}
