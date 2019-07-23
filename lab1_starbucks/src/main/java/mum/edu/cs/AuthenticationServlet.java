package mum.edu.cs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.data.*; 
/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/advice.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx = request.getServletContext();
 
		String name = request.getParameter("name");
		String password = request.getParameter("password");

  		DataFacade data = (DataFacade) getServletContext().getAttribute("dataSource");
		String expectedPassword = data.findPassword(name );
		
		if(expectedPassword == null || !expectedPassword.equals(password)) {
				
			response.sendRedirect("../index.jsp");
		} else {
			
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			writer.println("<!DOCTYPE html>");
			writer.println("<head><meta charset=\"ISO-8859-1\"><title>Insert title here</title></head>");

			writer.println("<body><h2>Login Successful</h2>");
			writer.println("<p /><form action=\"advice\" method=\"get\">");
			writer.println("<input type = \"submit\" value = \"Back\"/>");
			writer.println("</form>	</body>	</html>");
	//		response.sendRedirect("../LoginSuccessful.html");			
		}
	}

}
