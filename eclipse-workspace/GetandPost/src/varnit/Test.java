package varnit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       PrintWriter printWriter = response.getWriter();
//       StringBuilder str = new StringBuilder();
//	   str.append("<!DOCTYPE html>")
//	   .append("<html>")
//	   .append("<head>")
//	   .append("</head>")
//	   .append("<body>")
//	   .append("<form action='' method=\"POST\">")
//	   .append("       <p>Enter First Name :</p><br>")
//	   .append("       <input type=\"text\" name=\"fname\"><br>")
//	   .append("        <p>Enter Last Name :</p><br>")
//	   .append("       <input type=\"text\" name=\"lname\">")
//	   .append("        <p>Enter Password :</p><br>")
//	   .append("       <input type=\"text\" name=\"password\">")
//	   .append("       <input type=\"submit\" name=\"submit\" value=\"submit\">")
//	   .append("    </form>")
//	   .append("</body>")
//	   .append("</html>");
//	   printWriter.print(str);
	     // response.sendError(407, "Need authentication!!!" );
       response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	

	}

}
