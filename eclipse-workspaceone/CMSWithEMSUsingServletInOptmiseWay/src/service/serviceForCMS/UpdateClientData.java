package service.serviceForCMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseQueries;
import dto.Client;

/**
 * Servlet implementation class UpdateClientData
 */
@WebServlet("/UpdateClientData")
public class UpdateClientData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("id");
		Client client = new Client();
		@SuppressWarnings("unchecked")
		DatabaseQueries<Client> databaseQueries = (DatabaseQueries<Client>)DatabaseQueries.getObject();
		List<String> list = databaseQueries.readEmployee(uid, client);
		if(list.size()!=0) {
			request.setAttribute("valueOfId", list.get(0));
			request.setAttribute("valueOfFirstName", list.get(1));
			request.setAttribute("valueOfLastName", list.get(2));
			request.setAttribute("valueOfMobileNumber", list.get(3));
			request.setAttribute("valueOfEmail", list.get(4));
			request.setAttribute("valueOfBillAmount", list.get(5));
			request.setAttribute("valueOfTenure", list.get(6));
			request.setAttribute("errorInId", null);
			doPost(request, response);
		}else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		String errorInBillAmount = request.getAttribute("errorInBillAmount") == null ? ""
				: (String) request.getAttribute("errorInBillAmount");
		String errorInTenure = request.getAttribute("errorInTenure") == null ? ""
				: (String) request.getAttribute("errorInTenure");

		htmlCodeString.append("<!DOCTYPE html>").append("<html>").append("<body>").append("<style>")
				.append("input[type='text']").append("{")
				.append("margin-left:40px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;")
				.append("}").append("input[type='date']").append("{")
				.append("margin-left:40px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;")
				.append("}").append("p{margin-left:40px;}").append("span{margin-left:40px;color:red;}")
				.append("input[type='submit']").append("{")
				.append("margin-left:40px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append("</style>").append("<center><h1>Update Client Details</h1></center>")
				.append("<fieldset style = 'margin-left:350px;border-radius:5px;background-color:#D0D3D4;padding:0px;width:600px;'>")
				.append("<form action='FormValidationInCMS' method='POST'>")
				.append("<input type='hidden' name='url' value='UpdateClientData'>")
				.append("<input type='hidden' name='id' value='" + request.getAttribute("valueOfId") + "'>")
				.append("<p>Enter First name :<br>Enter only characters (For example:Virat)</p>")
				.append("<input type = 'text' name = 'fname' style='font-size:1rem' value = '" + request.getAttribute("valueOfFirstName")
						+ "'><br>")
				.append("<span>" + errorInFirstName + "</span>")
				.append("<p>Enter Last name :<br>Enter only characters (For example:Kohli)</p>")
				.append("<input type = 'text' name = 'lname' style='font-size:1rem' value = '" + request.getAttribute("valueOfLastName")
						+ "'><br>")
				.append("<span>" + errorInLastName + "</span>")
				.append("<p>Enter Mobile Number :<br>(Enter 10 digit Mobile Number with correct format)</p>")
				.append("<input type = 'text' name = 'mobileNumber' style='font-size:1rem' value = '"
						+ request.getAttribute("valueOfMobileNumber") + "'><br>")
				.append("<span>" + errorInMobileNumber + "</span>")
				.append("<p>Enter Email :<br>(For example:example@gmail.com)</p>")
				.append("<input type = 'text' name = 'email' style='font-size:1rem' value = '" + request.getAttribute("valueOfEmail")
						+ "'><br>")
				.append("<span>" + errorInEmail + "</span>")
				.append("<p>Enter BillAmount :<br>(Must be in numeric format)<br></p>")
				.append("<input type = 'text' name = 'billAmount' style='font-size:1rem' value = '"
						+ request.getAttribute("valueOfBillAmount") + "'><br>")
				.append("<span>" + errorInBillAmount + "</span>")
				.append("<p>Enter Tenure :<br>(Must lie between 0 to 14 in Integer format)</p>")
				.append("<input type = 'text' name = 'tenure' style='font-size:1rem' value = '" + request.getAttribute("valueOfTenure")
						+ "'><br>")
				.append("<span>" + errorInTenure + "</span><br><br>")
				.append("<input type = 'submit' value = 'submit' name = 'submit'>").append("</form>")
				.append("</fieldset>").append("</body>").append("</html>");
		printWriter.print(htmlCodeString);

	}

}
