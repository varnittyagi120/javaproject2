package service.serviceForCMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseQueries;
import dto.Client;
import util.Utility;

/**
 * Servlet implementation class ValidateInCMS
 */
@WebServlet("/FormValidationInCMS")
public class FormValidationInCMS extends HttpServlet {
	/**
	 * getObject(
	 */
	private static final long serialVersionUID = 1L;
	String regxForName = "^[a-zA-Z\\\\s]*$";
	String regxForMobileNumber = "(0/91)?[6-9][0-9]{9}";
	String regxForEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String url = request.getParameter("url");
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String billAmount = request.getParameter("billAmount");
		String tenure = request.getParameter("tenure");
		request.setAttribute("valueOfId", id);
		request.setAttribute("valueOfFirstName", fname);
		request.setAttribute("valueOfLastName", lname);
		request.setAttribute("valueOfMobileNumber", mobileNumber);
		request.setAttribute("valueOfEmail", email);
		request.setAttribute("valueOfBillAmount", billAmount);
		request.setAttribute("valueOfTenure", tenure);
		Utility utility = new Utility();
		boolean flag = true;
		if (fname.isEmpty()) {
			request.setAttribute("errorInFirstName", "Required");
			flag = false;
		} else {
			if (utility.validateStrings(fname, regxForName)) {
				request.setAttribute("errorInFirstName", null);
			} else {
				request.setAttribute("errorInFirstName", "Please enter only characters");
				flag = false;
			}
		}

		if (lname.isEmpty()) {
			request.setAttribute("errorInLastName", "Required");
			flag = false;
		} else {
			if (utility.validateStrings(lname, regxForName)) {
				request.setAttribute("errorInLastName", null);
			} else {
				request.setAttribute("errorInLastName", "Please enter only characters");
				flag = false;
			}
		}

		if (mobileNumber.isEmpty()) {
			request.setAttribute("errorInMobileNumber", "Required");
			flag = false;
		} else {
			if (utility.validateStrings(mobileNumber, regxForMobileNumber)) {
				request.setAttribute("errorInMobileNumber", null);
			} else {
				request.setAttribute("errorInMobileNumber", "please enter correct mobile number");
				flag = false;
			}
		}

		if (email.isEmpty()) {
			request.setAttribute("errorInEmail", "Required");
			flag = false;
		} else {
			if (utility.validateStrings(email, regxForEmail)) {
				request.setAttribute("errorInEmail", null);
			} else {
				request.setAttribute("errorInEmail", "please enter correct email");
				flag = false;
			}
		}
		if (billAmount.isEmpty()) {
			request.setAttribute("errorInBillAmount", "Required");
			flag = false;
		} else {
			try {
				Double.parseDouble(billAmount);
			} catch (Exception exception) {
				flag = false;
				request.setAttribute("errorInBillAmount", "Please enter billAmount in numeric format");
			}
		}

		if (tenure.isEmpty()) {
			request.setAttribute("errorInTenure", null);
		} else {
			if (!validateTenure(tenure)) {
				request.setAttribute("errorInTenure", "tenure must lie between the given range and in Integer format");
				flag = false;
			} else {
				request.setAttribute("errorInTenure", null);
			}
		}
		if (flag) {
			Client client = new Client();
			if(url.equals("AddNewClient")) {
				id = UUID.randomUUID().toString();
			}
			client.setUid(id);
			client.setFname(fname);
			client.setLname(lname);
			client.setMobileNumber(mobileNumber);
			client.setEmail(email);
			client.setBillAmount(billAmount);
			client.setTenure(tenure);
			@SuppressWarnings("unchecked")
			DatabaseQueries<Client> databaseQueries = (DatabaseQueries<Client>)DatabaseQueries.getObject();
			if(url.equals("AddNewClient")) {
				if (databaseQueries.addData(client.getDataOfClient(client), client)) {
					StringBuilder stringOfHtmlCodeInJava = new StringBuilder();
					stringOfHtmlCodeInJava.append("<!DOCTYPE html>").append("<html>").append("<body>")
							.append("alert('Data has been successfully inserted!')").append("</body>").append("</html>");
					request.getRequestDispatcher("ReadClients").forward(request, response);
				} else {
					printWriter.print("record not saved");
				}	
			}else {
						if (databaseQueries.updateData(id, client.getDataOfClient(client), client) > 0) {
							printWriter.print("data entered successfully");
							request.getRequestDispatcher("ReadClients").forward(request, response);
						} else {
							printWriter.print("record not saved");
						}
			}
		} else {
			if(url.equals("AddNewClient")) {
				request.getRequestDispatcher(url).forward(request, response);
			}else {
				request.getRequestDispatcher(url).forward(request, response);	
			}
			
		}
	}

	public boolean validateTenure(String tenure) {
		Integer tenureInInterger;
		try {
			tenureInInterger = Integer.parseInt(tenure);
		} catch (Exception excepton) {
			return false;
		}
		if (tenureInInterger < 0 || tenureInInterger > 14) {
			return false;
		}
		return true;
	}

}
