package service.serviceForEMS;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseQueries;
import dto.Employee;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Employee employee = new Employee();
		@SuppressWarnings("unchecked")
		DatabaseQueries<Employee> databaseQueries = (DatabaseQueries<Employee>)DatabaseQueries.getObject();
		if (databaseQueries.delete(id, employee) > 0) {
			request.setAttribute("errorInId", null);
			request.getRequestDispatcher("ReadEmployees").forward(request, response);
		}else {
			request.setAttribute("errorInId","please enter correct id");
			request.getRequestDispatcher("TakeInputForIdOfEmployee?url=DeleteEmployee").forward(request, response);
		}
	}

}
