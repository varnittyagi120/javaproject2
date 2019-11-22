package service.serviceForCMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DatabaseQueries;
import dto.Client;

/**
 * Servlet implementation class ReadClients
 */
@WebServlet("/ReadClients")
public class ReadClients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession session=request.getSession(false);  
			if(session==null){  
	            response.sendRedirect("LogIn");
			}
		PrintWriter printWriter = response.getWriter();
		StringBuilder stringOfHtmlCodeInJava = new StringBuilder();
		stringOfHtmlCodeInJava.append("<!DOCTYPE html>").append("<html>").append("<style>").append(".button")
				.append("{")
				.append("border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append("</style>").append("<body>").append("<center><h1>Clients List</h1><center>")
				.append("<a href = 'StartOfCMS'><button style='margin-left:1050px';name='menu' class=\"button\">Menu</button></a>")
				.append("<a href = 'Start'><button style='margin-left:10px';name='exit' class=\"button\">Exit</button></a><br><br>")
				.append("</body>").append("</html>");
		printWriter.print(stringOfHtmlCodeInJava);
		@SuppressWarnings("unchecked")
		DatabaseQueries<Client> databaseQueries = (DatabaseQueries<Client>)DatabaseQueries.getObject();
		Client client = new Client();
		List<List<String>> list = databaseQueries.readAllEmployees(client);
		if (list.size() == 0) {
			printWriter.print("<h2>No Entry Found</h2>");
		} else {
			printWriter.print("<table border = '1'  width = '100%'>");
			printWriter.print(
					"<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>MobileNumber</th><th>Email</th><th>BillAmount</th><th>Tenure</th><th>Edit</th><th>Delete</th></tr>");
			for (int i = 0; i < list.size(); i++) {
				printWriter.print("<tr><td>" + list.get(i).get(0) + "</td><td>" + list.get(i).get(1) + "</td><td>"
						+ list.get(i).get(2) + "</td><td>" + list.get(i).get(3) + "</td><td>" + list.get(i).get(4)
						+ "</td><td>" + list.get(i).get(5) + "</td><td>" + list.get(i).get(6)
						+ "</td><td><a href='UpdateClientData?id=" + list.get(i).get(0)
						+ "'>Edit</a></td><td><a href='DeleteClient?id=" + list.get(i).get(0)
						+ "'>Delete</a></td></tr>");
			}
			printWriter.print("</table>");
		}
	}

}
