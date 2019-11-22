package ssvalidation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ValidationFilterForRegistration
 */
@WebFilter("/ValidFilterOne")
public class ValidationFilterForRegistration implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password");
		PrintWriter printWriter = response.getWriter();
		if(fname.equals("")) {
			System.out.println("here1");
			String str = "Required";
			request.setAttribute("errfname",str);
			String err = (String)request.getParameter("errfname");
			System.out.println(err);
		}else {
			request.setAttribute("errfname", null);
		}
		if(lname.equals("")) {
			System.out.println("here2");
			String str = "Required";
			request.setAttribute("errlname",str);
			System.out.println(request.getParameter("errlname"));
		}else {
			request.setAttribute("errlname", null);
		}
		if(password.equals("")) {
			System.out.println("here3");
			String str = "Required";
			request.setAttribute("errpassword",str);
			System.out.println(request.getParameter("errpassword"));
		}else{
			request.setAttribute("errpassword", null);
		}
		if(fname.equals("")||lname.equals("")||password.equals("")) {
			request.getRequestDispatcher("ValidFilter").forward(request,response);
		}
		else
		{
		  chain.doFilter(request, response);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
