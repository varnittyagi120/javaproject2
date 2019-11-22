package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession(false);  
		String errorInUserName = request.getAttribute("errorInUserName") == null ? "" : (String) request.getAttribute("errorInUserName");
		String errorInPassword = request.getAttribute("errorInPassword") == null ? "" : (String) request.getAttribute("errorInPassword");
		String valueOfUserName = request.getAttribute("valueOfUserName") == null ? "" : (String) request.getAttribute("valueOfUserName");
		String valueOfPassword = request.getAttribute("valueOfPassword") == null ? "" : (String) request.getAttribute("valueOfPassword");
        PrintWriter printWriter = response.getWriter();
		StringBuilder htmlCodeString = new StringBuilder();
		if(session!=null){  
//			valueOfUserName=(String) session.getAttribute("userName")==null?"":(String) session.getAttribute("userName");
//			valueOfPassword=(String) session.getAttribute("password")==null?"":(String) session.getAttribute("password");
            response.sendRedirect("Start");
		}
		htmlCodeString.append("<!DOCTYPE html>").append("<html>").append("<body>").append("<style>")
				.append("input[type='text']").append("{")
				.append("margin-left:40px;border-radius:5px;border:1px solid #6EA72F;font-size:18pt;height:30px;width:500px;")
				.append("}").append("p{margin-left:40px;}").append("span{margin-left:40px;color:red;}")
				.append("input[type='submit']").append("{")
				.append("margin-left:40px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append(".button").append("{")
				.append("border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
				.append("}").append("</style>")
				.append("<center><h1>Login</h1></center>")
				.append("<fieldset style = 'margin-left:350px;border-radius:5px;background-color:#D0D3D4;padding:0px;width:600px;'>")
				.append("<form action='ValidateAdmin' method='POST'>").append("<p>Enter Username :<br></p>")
				.append("<input type = 'text' name = 'userName' style='font-size:1rem' value = '" + valueOfUserName + "'><br>")
				.append("<span>" + errorInUserName + "</span><br>").append("<p>Enter Password :<br></p>")
				.append("<input type = 'text' name = 'password' style='font-size:1rem' value = '" + valueOfPassword + "'><br>")
				.append("<span>" + errorInPassword + "</span><br>")
				.append("<input type = 'submit' value = 'submit' name = 'submit'>").append("</form>")
				.append("</fieldset>").append("</body>").append("</html>");
		printWriter.print(htmlCodeString);

	}

}
