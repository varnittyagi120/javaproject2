package varnit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPostServletOne
 */
@WebServlet("/GetPostServletOne")
public class GetPostServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		doGet(request,response);
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String fname = request.getParameter("fname");
        if(fname.equals("")) {
        	System.out.println("fname is "+fname);
        	request.setAttribute("errfname","required");
        	request.getRequestDispatcher("GetPostServlet").forward(request, response);
        }else {
        	printWriter.print(fname);
        }
	}

}
