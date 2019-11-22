package singleton;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Client;
import dao.Databasequeries;

/**
 * Servlet implementation class ReadOne
 */
@WebServlet("/ReadOne")
public class ReadOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	doPost(request,response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     Databasequeries<Client> databasequeries = (Databasequeries<Client>)Databasequeries.getObject();
	     System.out.println(databasequeries);
	}

}
