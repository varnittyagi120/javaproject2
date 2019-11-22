package employeeManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateDuringupdateion
 */
@WebServlet("/ValidateDuringupdation")
public class ValidateDuringupdation extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.print("here one");
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		request.setAttribute("valueOfId", id);
		request.setAttribute("valueOffname", fname);
		request.setAttribute("valueOflname", lname);
		request.setAttribute("valueOfpassword", password);
		request.setAttribute("valueOfemail", email);
		request.setAttribute("valueOfcountry", country);
		boolean flag = true;
		if (fname.isEmpty()) {
			request.setAttribute("errfname", "Required");
			System.out.println(request.getAttribute("errfname"));
			flag = false;
		} else {
			if (validateStrings(fname, regxForName)) {
				request.setAttribute("errfname", null);
			} else {
				request.setAttribute("errfname", "Please enter only characters");
				System.out.println(request.getAttribute("errfname"));
				flag = false;
			}
		}
		if (lname.isEmpty()) {
			request.setAttribute("errlname", "Required");
			System.out.println(request.getAttribute("errlname"));
			flag = false;
		} else {
			if (validateStrings(lname, regxForName)) {
				request.setAttribute("errlname", null);
			} else {
				request.setAttribute("errlname", "Please enter only characters");
				System.out.println(request.getAttribute("errlname"));
				flag = false;
			}
		}
		if (password.isEmpty()) {
			request.setAttribute("errpass", "Required");
			System.out.println("empty password " + request.getAttribute("errpass"));
			flag = false;
		} else {
			if (validateStrings(password, regxForPassword)) {
				request.setAttribute("errpass", null);
			} else {
				request.setAttribute("errpass", "Wrong password");
				flag = false;
			}
		}
		if (email.isEmpty()) {
			request.setAttribute("erremail", "Required");
			System.out.println(request.getAttribute("erremail"));
			flag = false;
		} else {
			if (validateStrings(email, regxForEmail)) {
				request.setAttribute("erremail", null);
			} else {
				request.setAttribute("erremail", "Wrong email");
				System.out.println(request.getAttribute("errmail"));
				flag = false;
			}
		}
		if (country.isEmpty()) {
			request.setAttribute("errcountry", "Required");
			System.out.println(request.getAttribute("errcountry"));
			flag = false;
		} else {
			request.setAttribute("errpassword", null);
		}
		if (flag) {
			Employee employee = new Employee();
			employee.setUid(id);
			employee.setFname(fname);
			employee.setLname(lname);
			employee.setPassword(password);
			employee.setEmail(email);
			employee.setCountry(country);
			Dao dao = new Dao();
			if (dao.update(employee) > 0) {
				printWriter.print("data entered successfully");
				request.getRequestDispatcher("ReadServlet").forward(request, response);
			} else {
				printWriter.print("record not saved");
			}
		} else {
			System.out.println("i am in else part");
			request.getRequestDispatcher("EditServletOne").forward(request, response);
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
