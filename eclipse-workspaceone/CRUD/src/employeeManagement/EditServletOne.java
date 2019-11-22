package employeeManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServletOne
 */
@WebServlet("/EditServletOne")
public class EditServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("id");
		System.out.println(uid);
		Dao dao = new Dao();
		Employee employee = dao.readEmployee(uid);
		request.setAttribute("valueOfId", employee.getUid());
		request.setAttribute("valueOffname", employee.getFname());
		request.setAttribute("valueOflname", employee.getLname());
		request.setAttribute("valueOfpassword", employee.getPassword());
		request.setAttribute("valueOfemail", employee.getEmail());
		request.setAttribute("valueOfcountry", employee.getCountry());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errFname = request.getAttribute("errfname") == null ? "" : (String) request.getAttribute("errfname");
		String errLname = request.getAttribute("errlname") == null ? "" : (String) request.getAttribute("errlname");
		String errPassword = request.getAttribute("errpass") == null ? "" : (String) request.getAttribute("errpass");
		String errEmail = request.getAttribute("erremail") == null ? "" : (String) request.getAttribute("erremail");
		String errCountry = request.getAttribute("errcountry") == null ? ""
				: (String) request.getAttribute("errcountry");
		System.out.println(errFname);
		System.out.println("Error in password " + request.getAttribute("errpassword"));
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<!DOCTYPE html>");
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print("<center><h1>Update employee data</h1></center>");
		printWriter.print("<form action ='ValidateDuringupdation' method ='POST'>");
		printWriter.print("<input type='hidden' name='id' value='" + request.getAttribute("valueOfId") + "'>");
		printWriter.print("<p style='margin-left:450px' id = \"fname\">Enter First Name :</p>");
		printWriter.print("<input type=\"text\" name = \"fname\" value ='" + request.getAttribute("valueOffname")
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errFname + "</span>");
		printWriter.print("<p style='margin-left:450px' id = \"lname\">Enter Last Name  :</p>");
		printWriter.print("<input type=\"text\" name = \"lname\" value ='" + request.getAttribute("valueOflname")
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errLname + "</span>");
		printWriter.print(
				"<p style='margin-left:450px' id = \"password\">Enter Password : <br>Minimum 8 characters for example :<br>Example@13</p>");
		printWriter.print("<input type = \"text\" name = \"password\" value ='"
				+ request.getAttribute("valueOfpassword")
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errPassword + "</span>");
		printWriter.println(
				"<p style='margin-left:450px' id = \"email\">Enter Email<br>For example(example@gmail.com) :</p>");
		printWriter.print("<input type=\"text\" name=\"email\" value ='" + request.getAttribute("valueOfemail")
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errEmail + "</span>");
		printWriter.println("<p style='margin-left:450px' id = \"country\">Enter Country :</p>");
		printWriter.print("<input type=\"text\" name=\"country\" value ='" + request.getAttribute("valueOfcountry")
				+ "' style=\"margin-left:450px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;\"><br>");
		printWriter.print("<span style=\"color:red;margin-left:450px;\">" + errCountry + "</span><br><br>");
		printWriter.print(
				"<input type=\"submit\" name=\"submit\"style =\"margin-left:450px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;\" value=\"submit\">");
		printWriter.print("</form>");
		printWriter.print("</html>");
		printWriter.print("</body>");
	}
}
