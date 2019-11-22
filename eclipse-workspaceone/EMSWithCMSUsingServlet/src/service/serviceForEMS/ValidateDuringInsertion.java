package service.serviceForEMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseQueries;
import dto.Employee;
import util.Utility;

/**
 * Servlet implementation class ValidateDuringInsertion
 */
@WebServlet("/ValidateDuringInsertion")
public class ValidateDuringInsertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String regxForName = "^[a-zA-Z\\\\s]*$";
	String regxForMobileNumber = "(0/91)?[6-9][0-9]{9}";
	String regxForEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String dateOfJoining = request.getParameter("dateOfJoining");
		String salary = request.getParameter("salary");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		boolean flag = true;
		Utility utility = new Utility();

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
		if (dateOfJoining.isEmpty()) {
			request.setAttribute("errorInDateOfJoining", "Required");
			flag = false;
		} else {
			try {
				Date startingDateOfCompany = sdf.parse("2005-01-01");
				Date currentDate = sdf.parse(dtf.format(now));
				Date dateOfJoiningOfEmployee = sdf.parse(dateOfJoining);
				if (currentDate.compareTo(dateOfJoiningOfEmployee) < 0
						|| dateOfJoiningOfEmployee.compareTo(startingDateOfCompany) < 0) {
					request.setAttribute("errorInDateOfJoining", "date must lie between the given range");
					flag = false;
				} else {
					request.setAttribute("errorInDateOfJoining", null);
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		if (salary.isEmpty()) {
			request.setAttribute("errorRelatedToSalary", null);
		} else {
			if (!validateSalary(salary)) {
				request.setAttribute("errorRelatedToSalary",
						"salary must lie between the given range and in numeric format");
				flag = false;
			} else {
				request.setAttribute("errorRelatedToSalary", null);
			}
		}
		if (flag) {
			Employee employee = new Employee();
			String uniqueID = UUID.randomUUID().toString();
			employee.setUid(uniqueID);
			employee.setFname(fname);
			employee.setLname(lname);
			employee.setMobileNumber(mobileNumber);
			employee.setEmail(email);
			employee.setDateOfJoining(dateOfJoining);
			employee.setSalary(salary);
			DatabaseQueries<Employee> databaseQueries = DatabaseQueries.getObject();
			if (databaseQueries.addData(employee.getDataOfEmployee(employee), employee)) {
				StringBuilder stringOfHtmlCodeInJava = new StringBuilder();
				stringOfHtmlCodeInJava.append("<!DOCTYPE html>").append("<html>").append("<body>")
						.append("alert('Data has been successfully inserted!')").append("</body>").append("</html>");
				request.getRequestDispatcher("ReadEmployees").forward(request, response);
			} else {
				printWriter.print("record not saved");
			}
		} else {
			request.getRequestDispatcher("AddNewEmployee").forward(request, response);
		}
	}

	public boolean validateSalary(String salary) {
		try {
			double salaryInDouble = Double.parseDouble(salary);
			if (salaryInDouble < 10000 || salaryInDouble > 100000) {
				return false;
			}
		} catch (Exception exception) {
			return false;
		}
		return true;
	}

}
