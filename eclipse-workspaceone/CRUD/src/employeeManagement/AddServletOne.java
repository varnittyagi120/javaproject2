package employeeManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServletOne
 */
@WebServlet("/AddServletOne")
public class AddServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String errFname = request.getAttribute("errfname") == null ? "" : (String) request.getAttribute("errfname");
		String errLname = request.getAttribute("errlname") == null ? "" : (String) request.getAttribute("errlname");
		String errPassword = request.getAttribute("errpassword") == null ? ""
				: (String) request.getAttribute("errpassword");
		String errEmail = request.getAttribute("erremail") == null ? "" : (String) request.getAttribute("erremail");
		String errCountry = request.getAttribute("errcountry") == null ? ""
				: (String) request.getAttribute("errcountry");
		String valueFname = request.getParameter("fname") == null ? "" : request.getParameter("fname");
		String valueLname = request.getParameter("lname") == null ? "" : request.getParameter("lname");
		String valuePassword = request.getParameter("password") == null ? "" : request.getParameter("password");
		String valueEmail = request.getParameter("email") == null ? "" : request.getParameter("email");
		String valueCountry = request.getParameter("country") == null ? "" : request.getParameter("country");

		printWriter.println("<!DOCTYPE html>");
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print(
				"<a href='index.html'><button style='border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 10px 25px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;'"
						+ ">Home</button></a>");
		printWriter.print(
				"<a href='ReadServlet'><button style='margin-left:30px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 10px 25px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;'"
						+ ">View employees</button></a>");
		printWriter.print("<center><h1>Add New Employee</h1></center>");
		printWriter.print("<form action = 'ValidateDuringInsertion' method = 'POST'>");
		printWriter.print("<p style='margin-left:450px' id = \"fname\">Enter First Name :</p>");
		printWriter.print("<input type=\"text\" name = \"fname\" value ='" + valueFname
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errFname + "</span>");
		printWriter.print("<p style='margin-left:450px' id = \"lname\">Enter Last Name  :</p>");
		printWriter.print("<input type=\"text\" name = \"lname\" value ='" + valueLname
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errLname + "</span>");
		printWriter.print(
				"<p style='margin-left:450px' id = \"password\">Enter Password : <br>Minimum 8 characters for example :<br>Example@13</p>");
		printWriter.print("<input type = \"text\" name = \"password\" value ='" + valuePassword
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errPassword + "</span>");
		printWriter.println(
				"<p style='margin-left:450px' id = \"email\">Enter Email<br>For example(example@gmail.com) :</p>");
		printWriter.print("<input type=\"text\" name=\"email\" value ='" + valueEmail
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errEmail + "</span>");
		printWriter.println("<p style='margin-left:450px' id = \"country\">Enter Country :</p>");
		printWriter.print("<input type=\"text\" name=\"country\" value ='" + valueCountry
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errCountry + "</span><br><br>");
		printWriter.print(
				"<input type=\"submit\" name=\"submit\"style =\"margin-left:450px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;\" value=\"submit\">");
		printWriter.print("</form>");
		printWriter.print("</html>");
		printWriter.print("</body>");
		printWriter.print("<br>");

	}

}
