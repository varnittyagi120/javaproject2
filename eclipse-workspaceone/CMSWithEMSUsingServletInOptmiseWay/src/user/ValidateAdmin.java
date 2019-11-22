package user;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class ValidateAdmin
 */
@WebServlet("/ValidateAdmin")
public class ValidateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		request.setAttribute("valueOfUserName", userName);
		request.setAttribute("valueOfPassword", password);
		boolean flag = true;
		if (userName.isEmpty()) {
			request.setAttribute("errorInUserName", "Required");
			flag = false;
		} else {
			if (userName.equals("raghav@12")) {
				request.setAttribute("errorInUserName", null);
			} else {
				request.setAttribute("errorInUserName", "username mismatched");
				flag = false;
			}
		}

		if (password.isEmpty()) {
			request.setAttribute("errorInPassword", "Required");
			flag = false;
		} else {
			if (password.equals("root@123")) {
				request.setAttribute("errorInPassword", null);
			} else {
				request.setAttribute("errorInPassword", "password mismatch");
				flag = false;
			}
		}
		if (flag) {
	        HttpSession session=request.getSession();  
	        if(session!=null) {
	           session.setAttribute("userName",userName);
	           session.setAttribute("password",password);
	        }
			request.getRequestDispatcher("Start").forward(request, response);
		} else {
			request.getRequestDispatcher("LogIn").forward(request, response);

		}
	}

}
