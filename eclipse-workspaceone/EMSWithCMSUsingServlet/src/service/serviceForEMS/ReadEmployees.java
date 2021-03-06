package service.serviceForEMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseQueries;
import dto.Employee;

/**
 * Servlet implementation class CMSManagement
 */
@WebServlet("/ReadEmployees")
public class ReadEmployees extends HttpServlet {
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
		StringBuilder stringOfHtmlCodeInJava = new StringBuilder();
		stringOfHtmlCodeInJava.append("<!DOCTYPE html>").append("<html>").append("<style>").append(".button")
				.append("{")
				.append("border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append("</style>").append("<body>").append("<center><h1>Employee List</h1><center>")
				.append("<a href = 'StartOfEMS'><button style='margin-left:1050px';name='menu' class=\"button\">Menu</button></a>")
				.append("<a href = 'index.html'><button style='margin-left:10px';name='exit' class=\"button\">Exit</button></a><br><br>")
				.append("</body>").append("</html>");
		printWriter.print(stringOfHtmlCodeInJava);
		DatabaseQueries<Employee> databaseQueries = DatabaseQueries.getObject();
		Employee employee = new Employee();
		List<List<String>> list = databaseQueries.readAllEmployees(employee);
		if (list.size() == 0) {
			printWriter.print("<h2>No Entry Found</h2>");
		} else {
			printWriter.print("<table border = '1'  width = '100%'>");
			printWriter.print(
					"<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>MobileNumber</th><th>Email</th><th>DateOfJoining</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>");
			for (int i = 0; i < list.size(); i++) {
				printWriter.print("<tr><td>" + list.get(i).get(0) + "</td><td>" + list.get(i).get(1) + "</td><td>"
						+ list.get(i).get(2) + "</td><td>" + list.get(i).get(3) + "</td><td>" + list.get(i).get(4)
						+ "</td><td>" + list.get(i).get(5) + "</td><td>" + list.get(i).get(6)
						+ "</td><td><a href='UpdateEmployeeData?id=" + list.get(i).get(0)
						+ "'>Edit</a></td><td><a href='DeleteEmployee?id=" + list.get(i).get(0)
						+ "'>Delete</a></td></tr>");
			}
			printWriter.print("</table>");
		}
	}

}
