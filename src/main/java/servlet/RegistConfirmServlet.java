package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistConfirmServlet
 */
@WebServlet("/RegistConfirmServlet")
public class RegistConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String age = "";
		if (!request.getParameter("age").isEmpty()) {
			age = request.getParameter("age"); 
		}
		String place = "";
		if (!request.getParameter("place").isEmpty()) {
			place = request.getParameter("place"); 
		}
		String FTP = "";
		if (!request.getParameter("FTP").isEmpty()) {
			FTP = request.getParameter("FTP"); 
		}
		String howlong = "";
		if (!request.getParameter("howlong").isEmpty()) {
			howlong = request.getParameter("howlong"); 
		}
		String comment = "";
		if (!request.getParameter("comment").isEmpty()) {
			comment = request.getParameter("comment"); 
		}
		request.setAttribute("name", name);
		request.setAttribute("pass", pass);
		request.setAttribute("age", age);
		request.setAttribute("place", place);
		request.setAttribute("FTP", FTP);
		request.setAttribute("howlong", howlong);
		request.setAttribute("comment", comment);
		RequestDispatcher rd = request.getRequestDispatcher("/RegistConfirm.jsp");
		rd.forward(request, response);
	}

}
