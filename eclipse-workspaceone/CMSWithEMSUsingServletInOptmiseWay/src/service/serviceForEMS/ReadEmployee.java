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
 * Servlet implementation class ReadEmployee
 */
@WebServlet("/ReadEmployee")
public class ReadEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String id = request.getParameter("id");
		Employee employee = new Employee();
		@SuppressWarnings("unchecked")
		DatabaseQueries<Employee> databaseQueries = (DatabaseQueries<Employee>)DatabaseQueries.getObject();
		List<String> list = databaseQueries.readEmployee(id, employee);
		if (list.size() > 0) {
			StringBuilder stringOfHTMLCodeInJava = new StringBuilder();
			stringOfHTMLCodeInJava.append("<!DOCTYPE html>").append("<html>").append("<style>").append(".button")
					.append("{")
					.append("border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
					.append("}").append("</style>").append("<body>")
					.append("<center><h1>Details Of Employee</h1></center>")
					.append("<a href = 'StartOfEMS'><button style='margin-left:1050px';name='menu' class=\"button\">Menu</button></a>")
					.append("<a href = 'Start'><button style='margin-left:10px';name='exit' class=\"button\">Exit</button></a><br><br>")
					.append("<table border = '1'  width = '100%'>")
					.append("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>MobileNumber</th><th>Email</th><th>DateOfJoining</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>")
					.append("<tr><td>" + list.get(0) + "</td><td>" + list.get(1) + "</td><td>" + list.get(2)
							+ "</td><td>" + list.get(3) + "</td><td>" + list.get(4) + "</td><td>" + list.get(5)
							+ "</td><td>" + list.get(6) + "</td><td><a href='UpdateEmployeeData?id=" + list.get(0)
							+ "'>Edit</a></td><td><a href='DeleteEmployee?id=" + list.get(0) + "'>Delete</a></td></tr>")
					.append("</table>").append("</body>").append("</html>");
			printWriter.print(stringOfHTMLCodeInJava);
			request.setAttribute("errorInId", null);
		} else {
			request.setAttribute("errorInId", "Please enter correct id");
			request.getRequestDispatcher("TakeInputForIdOfEmployee?url=ReadEmployee").forward(request, response);
		}

	}

}
