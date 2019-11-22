package service.serviceForCMS;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TakeInputIdOfClient
 */
@WebServlet("/TakeInputForIdOfClient")
public class TakeInputForIdOfClient extends HttpServlet {
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
		String errorInId = request.getAttribute("errorInId") == null ? "" : (String) request.getAttribute("errorInId");
		String valueOfId = request.getParameter("id") == null ? "" : request.getParameter("id");
        String url = request.getParameter("url");
		PrintWriter printWriter = response.getWriter();
		StringBuilder htmlCodeString = new StringBuilder();
		htmlCodeString.append("<!DOCTYPE html>").append("<html>").append("<body>").append("<style>")
				.append("input[type='text']").append("{")
				.append("margin-left:40px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;")
				.append("}").append("p{margin-left:40px;}").append("span{margin-left:40px;color:red;}")
				.append("input[type='submit']").append("{")
				.append("margin-left:40px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append(".button").append("{")
				.append("border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append("</style>").append("<center><h1>Enter Client Id For Performing Selected Operation</h1></center>")
				.append("<a href = 'StartOfCMS'><button style='margin-left:1050px';name='menu' class=\"button\">Menu</button></a>")
				.append("<a href = 'Start'><button style='margin-left:10px';name='exit' class=\"button\">Exit</button></a><br><br>")
				.append("<fieldset style = 'margin-left:350px;border-radius:5px;background-color:#D0D3D4;padding:0px;width:600px;'>")
				.append("<form action='"+url+"' method='POST'>").append("<p>Enter Client Id :<br></p>")
				.append("<input type = 'text' name = 'id' style='font-size:1rem' value = '" + valueOfId + "'><br>")
				.append("<span>" + errorInId + "</span><br>")
				.append("<input type = 'submit' value = 'submit' name = 'submit'>").append("</form>")
				.append("</fieldset>").append("</body>").append("</html>");
		printWriter.print(htmlCodeString);

	}

}
