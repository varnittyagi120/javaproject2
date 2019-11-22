package management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status=0;
		  PrintWriter printWriter = response.getWriter();
		  String fname = request.getParameter("fname");
		  String lname = request.getParameter("lname");
		  String password = request.getParameter("password");
		  String email = request.getParameter("email");
		  String country = request.getParameter("country");
		  Employee employee = new Employee();
		  employee.setFname(fname);
		  employee.setLname(lname);
		  employee.setPassword(password);
		  employee.setEmail(email);
		  employee.setCountry(country);  
		  EmpDao empDao=new EmpDao();
		  status = empDao.addition(employee);
		  if(status > 0) {
			  printWriter.print("<p>\"Record saved successfully!\"</p>");  
		  }else {
			  printWriter.print("<p>\"Sorry! unable to save record\"</p>");
		  }
	}

}
