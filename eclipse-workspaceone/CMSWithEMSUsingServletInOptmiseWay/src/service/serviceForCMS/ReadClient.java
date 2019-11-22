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
 * Servlet implementation class ReadClient
 */
@WebServlet("/ReadClient")
public class ReadClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String id = request.getParameter("id");
		Client client = new Client();
		@SuppressWarnings("unchecked")
		DatabaseQueries<Client> databaseQueries = (DatabaseQueries<Client>)DatabaseQueries.getObject();
		List<String> list = databaseQueries.readEmployee(id, client);
		if (list.size() > 0) {
			StringBuilder stringOfHTMLCodeInJava = new StringBuilder();
			stringOfHTMLCodeInJava.append("<!DOCTYPE html>").append("<html>").append("<style>").append(".button")
					.append("{")
					.append("border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
					.append("}").append("</style>").append("<body>")
					.append("<center><h1>Details Of Client</h1></center>")
					.append("<a href = 'StartOfCMS'><button style='margin-left:1050px';name='menu' class=\"button\">Menu</button></a>")
					.append("<a href = 'Start'><button style='margin-left:10px';name='exit' class=\"button\">Exit</button></a><br><br>")
					.append("<table border = '1'  width = '100%'>")
					.append("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>MobileNumber</th><th>Email</th><th>BillAmount</th><th>Tenure</th><th>Edit</th><th>Delete</th></tr>")
					.append("<tr><td>" + list.get(0) + "</td><td>" + list.get(1) + "</td><td>" + list.get(2)
							+ "</td><td>" + list.get(3) + "</td><td>" + list.get(4) + "</td><td>" + list.get(5)
							+ "</td><td>" + list.get(6) + "</td><td><a href='UpdateClientData?id=" + list.get(0)
							+ "'>Edit</a></td><td><a href='DeleteClient?id=" + list.get(0) + "'>Delete</a></td></tr>")
					.append("</table>").append("</body>").append("</html>");
			printWriter.print(stringOfHTMLCodeInJava);
			request.setAttribute("errorInId", null);
		} else {
			request.setAttribute("errorInId", "Please enter correct id");
			request.getRequestDispatcher("TakeInputForIdOfClient?url=ReadClient").forward(request, response);
		}

	}

}
