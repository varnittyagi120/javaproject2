package ssvalidation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidFilter
 */
@WebServlet("/ValidFilter")
public class ValidFilter extends HttpServlet {
	    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doPost(request,response);
	    }
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         PrintWriter printWriter = response.getWriter();
         String errFname=request.getParameter("errfname")==null?"":request.getParameter("errfname");
	     String errLname=request.getParameter("errlname")==null?"":request.getParameter("errfname");
	     String errPassword=request.getParameter("errpassword")==null?"":request.getParameter("errfname");
	     System.out.println(errFname);
	     System.out.println(errLname);
	     System.out.println(errPassword);
         printWriter.println("<!DOCTYPE html>");
	     printWriter.print("<html>");
	     printWriter.print("<body>");
	     printWriter.print("<h1>Add New Employee</h1>");
	     printWriter.print("<form action = 'ValidFilterOne' method = 'POST'>");
	     printWriter.print("<p id = \"fname\">Enter First Name :</p>");
	     printWriter.print("<input type=\"text\" name = \"fname\"><br>");
	     printWriter.print("<span>"+errFname+"</span>");
	     printWriter.print("<p id = \"lname\">Enter Last Name  :</p>");
	     printWriter.print("<input type=\"text\" name = \"lname\"><br>");
	     printWriter.print("<span>"+errLname+"</span>");
	     printWriter.print("<p id = \"password\">Enter Password  :</p>");
	     printWriter.print("<input type = \"text\" name = \"password\"><br>");
	     printWriter.print("<span>"+errPassword+"</span>");
	     printWriter.print("<input type=\"submit\" name=\"submit\" value=\"submit\">");
	     printWriter.print("</form>");
	     printWriter.print("</html>");
	     printWriter.print("</body>");
		
		}

}
