package service.serviceForCMS;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseQueries;
import dto.Client;

/**
 * Servlet implementation class DeleteClient
 */
@WebServlet("/DeleteClient")
public class DeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Client client = new Client();
		@SuppressWarnings("unchecked")
		DatabaseQueries<Client> databaseQueries = (DatabaseQueries<Client>)DatabaseQueries.getObject();
		if (databaseQueries.delete(id, client) > 0) {
			request.setAttribute("errorInId", null);
			request.getRequestDispatcher("ReadClients").forward(request, response);
		}else{
			request.setAttribute("errorInId","please enter correct id");
			request.getRequestDispatcher("TakeInputForIdOfClient?url=DeleteClient").forward(request, response);
		}
	}

}
