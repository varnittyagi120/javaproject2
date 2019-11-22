package employeeManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.print(
				"<a href='index.html'><button style='border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 10px 25px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;'"
						+ ">Home</button></a>");
		printWriter.print(
				"<a href='AddServletOne'><button style='margin-left:30px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 10px 25px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;'"
						+ ">AddNewEmployee</button></a>");
		printWriter.print("<center><h1>Employee List</h1><center>");
		Dao dao = new Dao();
		List<Employee> list = dao.readAllEmployees();
		if (list.size() == 0) {
			printWriter.print("<h2>No Entry Found</h2>");
		} else {
			printWriter.print("<table border = '1'  width = '100%'>");
			printWriter.print(
					"<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
			for (Employee employee : list) {
				printWriter.print("<tr><td>" + employee.getUid() + "</td><td>" + employee.getFname() + "</td><td>"
						+ employee.getLname() + "</td><td>" + employee.getPassword() + "</td><td>" + employee.getEmail()
						+ "</td><td>" + employee.getCountry() + "</td><td><a href='EditServletOne?id="
						+ employee.getUid() + "'>Edit</a></td><td><a href='DeleteServlet?id=" + employee.getUid()
						+ "'>Delete</a></td></tr>");
			}
			printWriter.print("</table>");
		}

	}

}
