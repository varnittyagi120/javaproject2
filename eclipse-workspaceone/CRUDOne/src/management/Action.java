package management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Action
 */
@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buttonParameter = request.getParameter("submit");
        RequestDispatcher requestDispatcher=null;
        if(buttonParameter.equals("ADD")) {
        	addData(request,response);
        }else if(buttonParameter.equals("UPDATE")) {
        	requestDispatcher = request.getRequestDispatcher("UpdateServlet");
        }else if(buttonParameter.equals("READ")) {
        	requestDispatcher = request.getRequestDispatcher("ReadServlet");
        }else if(buttonParameter.equals("DELETE")) {
        	requestDispatcher = request.getRequestDispatcher("DeleteServlet");
        }
        requestDispatcher.forward(request,response);

	}
	public void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		PrintWriter printWriter = response.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html><body>");
        printWriter.println("<form action=\"AddServlet\" method=\"POST\">");
        printWriter.println("Enter First Name : <input type=\"text\" name=\"fname\"> <br><br>");
        printWriter.println("Enter Last Name  : <input type=\"text\" name=\"lname\"> <br><br>");
        printWriter.println("Enter Password   : <input type=\"text\" name=\"password\"> <br><br>");
        printWriter.println("Enter Email      : <input type=\"text\" name=\"email\"> <br><br>");
        printWriter.println("Enter Country    : <input type=\"text\" name=\"country\"> <br><br>");
        printWriter.println("<input type=\"submit\" name=\"submit\"> <br><br>");
        printWriter.println("</form>");
        printWriter.println("</html></body>");
	}

}
