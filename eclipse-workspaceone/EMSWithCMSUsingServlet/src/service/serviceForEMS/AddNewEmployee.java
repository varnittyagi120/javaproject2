
package service.serviceForEMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EMSManagement
 */
@WebServlet("/AddNewEmployee")
public class AddNewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		StringBuilder htmlCodeString = new StringBuilder();
		String errorInFirstName = request.getAttribute("errorInFirstName") == null ? ""
				: (String) request.getAttribute("errorInFirstName");
		String errorInLastName = request.getAttribute("errorInLastName") == null ? ""
				: (String) request.getAttribute("errorInLastName");
		String errorInMobileNumber = request.getAttribute("errorInMobileNumber") == null ? ""
				: (String) request.getAttribute("errorInMobileNumber");
		String errorInEmail = request.getAttribute("errorInEmail") == null ? ""
				: (String) request.getAttribute("errorInEmail");
		String errorInDateOfJoining = request.getAttribute("errorInDateOfJoining") == null ? ""
				: (String) request.getAttribute("errorInDateOfJoining");
		String errorRelatedToSalary = request.getAttribute("errorRelatedToSalary") == null ? ""
				: (String) request.getAttribute("errorRelatedToSalary");

		String valueOfFirstName = request.getParameter("fname") == null ? "" : request.getParameter("fname");
		String valueOfLastName = request.getParameter("lname") == null ? "" : request.getParameter("lname");
		String valueOfMobileNumber = request.getParameter("mobileNumber") == null ? ""
				: request.getParameter("mobileNumber");
		String valueOfEmail = request.getParameter("email") == null ? "" : request.getParameter("email");
		String valueOfDateOfJoining = request.getParameter("dateOfJoining") == null ? ""
				: request.getParameter("dateOfJoining");
		String valueOfSalary = request.getParameter("salary") == null ? "" : request.getParameter("salary");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();

		htmlCodeString.append("<!DOCTYPE html>").append("<html>").append("<body>").append("<style>")
				.append("input[type='text']").append("{")
				.append("margin-left:40px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;")
				.append("}").append("input[type='date']").append("{")
				.append("margin-left:40px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;")
				.append("}").append("p{margin-left:40px;}").append("span{margin-left:40px;color:red;}")
				.append("input[type='submit']").append("{")
				.append("margin-left:40px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append(".button").append("{")
				.append("border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append("</style>").append("<center><h1>Add New Employee</h1></center>")
				.append("<a href = 'StartOfEMS'><button style='margin-left:1050px';name='menu' class=\"button\">Menu</button></a>")
				.append("<a href = 'index.html'><button style='margin-left:10px';name='exit' class=\"button\">Exit</button></a><br><br>")
				.append("<fieldset style = 'margin-left:350px;border-radius:5px;background-color:#D0D3D4;padding:0px;width:600px;'>")
				.append("<form action='ValidateDuringInsertion' method='POST'>")
				.append("<p>Enter First name :<br>Enter only characters (For example:Virat)</p>")
				.append("<input type = 'text' name = 'fname' value = '" + valueOfFirstName + "'><br>")
				.append("<span>" + errorInFirstName + "</span>")
				.append("<p>Enter Last name :<br>Enter only characters (For example:Kohli)</p>")
				.append("<input type = 'text' name = 'lname' value = '" + valueOfLastName + "'><br>")
				.append("<span>" + errorInLastName + "</span>")
				.append("<p>Enter Mobile Number :<br>(Enter 10 digit Mobile Number with correct format)</p>")
				.append("<input type = 'text' name = 'mobileNumber' value = '" + valueOfMobileNumber + "'><br>")
				.append("<span>" + errorInMobileNumber + "</span>")
				.append("<p>Enter Email :<br>(For example:example@gmail.com)</p>")
				.append("<input type = 'text' name = 'email' value = '" + valueOfEmail + "'><br>")
				.append("<span>" + errorInEmail + "</span>")
				.append("<p>Enter DateOfJoining :<br>(Must lie between 01-01-2005 to " + dtf.format(now) + ")<br></p>")
				.append("<input type = 'date' name = 'dateOfJoining' style='font-size:1rem' value = '"
						+ valueOfDateOfJoining + "'><br>")
				.append("<span>" + errorInDateOfJoining + "</span>")
				.append("<p>Enter Salary (Optional) :<br>(Must lie between 10000 to 100000 in numeric format)</p>")
				.append("<input type = 'text' name = 'salary' value = '" + valueOfSalary + "'><br>")
				.append("<span>" + errorRelatedToSalary + "</span><br><br>")
				.append("<input type = 'submit' value = 'submit' name = 'submit'>").append("</form>")
				.append("</fieldset>").append("</body>").append("</html>");
		printWriter.print(htmlCodeString);

	}

}
