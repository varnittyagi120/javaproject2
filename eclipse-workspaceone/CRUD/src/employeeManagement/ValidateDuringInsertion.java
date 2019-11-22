package employeeManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/ValidateDuringInsertion")
public class ValidateDuringInsertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String regxForName = "^[a-zA-Z\\\\s]*$";
	String regxForPassword = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
	String regxForEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	/**
	 * @throws IOException
	 * @throws ServletException
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
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		boolean flag = true;
		if (fname.isEmpty()) {
			request.setAttribute("errfname", "Required");
			flag = false;
		} else {
			if (validateStrings(fname, regxForName)) {
				request.setAttribute("errfname", null);
			} else {
				request.setAttribute("errfname", "Please enter only characters");
				flag = false;
			}
		}
		if (lname.isEmpty()) {
			request.setAttribute("errlname", "Required");
			flag = false;
		} else {
			if (validateStrings(lname, regxForName)) {
				request.setAttribute("errlname", null);
			} else {
				request.setAttribute("errlname", "Please enter only characters");
				flag = false;
			}
		}
		if (password.isEmpty()) {
			request.setAttribute("errpassword", "Required");
			flag = false;
		} else {
			if (validateStrings(password, regxForPassword)) {
				request.setAttribute("errpassword", null);
			} else {
				request.setAttribute("errpassword", "Wrong password");
				flag = false;
			}
		}
		if (email.isEmpty()) {
			request.setAttribute("erremail", "Required");
			flag = false;
		} else {
			if (validateStrings(email, regxForEmail)) {
				request.setAttribute("erremail", null);
			} else {
				request.setAttribute("erremail", "Wrong email");
				flag = false;
			}
		}
		if (country.isEmpty()) {
			request.setAttribute("errcountry", "Required");
			flag = false;
		} else {
			request.setAttribute("errpassword", null);
		}
		if (flag) {
			Employee employee = new Employee();
			String uniqueID = UUID.randomUUID().toString();
			employee.setUid(uniqueID);
			employee.setFname(fname);
			employee.setLname(lname);
			employee.setPassword(password);
			employee.setEmail(email);
			employee.setCountry(country);
			Dao dao = new Dao();
			if (dao.insert(employee) > 0) {
				printWriter.print("data entered successfully");
				request.getRequestDispatcher("ReadServlet").forward(request, response);
			} else {
				printWriter.print("record not saved");
			}
		} else {
			request.getRequestDispatcher("AddServletOne").forward(request, response);
		}
	}

	public boolean validateStrings(String string, String regx) {
		Pattern pattern = Pattern.compile(new String(regx));
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

}
