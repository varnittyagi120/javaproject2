package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartOfCMS
 */
@WebServlet("/StartOfCMS")
public class StartOfCMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        StringBuilder htmlCodeString = new StringBuilder();
        htmlCodeString.append("<!DOCTYPE html>")
        .append("<html>")
        .append("<body>")
        .append("<style>")
        .append(".button{")
        .append("border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
        .append("}")
        .append(".button[name='exit']{")
        .append("margin-left:1200px;border-radius:5px;background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;")
        .append("}")
        .append("</style>")
        .append("<center><h1>Welcome You Are In CMS</h1></center>")
        .append("<a href = 'index.html'><button name='exit' class=\"button\">Exit</button></a><br><br>")
        .append("<fieldset style = 'background-color:#D0D3D4;border-radius:5px'>")
        .append("<legend>Choose any operation</legend>")
        .append("<a href = \"AddNewClient\"><button class=\"button\" >AddClientData</button></a><br><br>")
        .append("<a href = \"TakeInputForReadClient\"><button class=\"button\" >ReadClientData</button></a><br><br>")
        .append("<a href = \"ReadClients\"><button class=\"button\" >ReadClientsData</button></a><br><br><br>")
        .append("<a href = \"TakeInputForReadClient\"><button class=\"button\" >UpdateClientData</button></a><br><br><br>")
        .append("<a href = \"TakeInputForDeletionInCMS\"><button class=\"button\" >DeleteClientData</button></a><br><br>")
        .append("</fieldset>")
        .append("</body>")
        .append("</html>");
        printWriter.print(htmlCodeString);

	}

}
