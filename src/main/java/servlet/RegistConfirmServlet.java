package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Person;

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
		int  age=0;
		if (!request.getParameter("age").isEmpty()) {
			age = Integer.parseInt(request.getParameter("age")); 
		}
		String place = "";
		if (!request.getParameter("place").isEmpty()) {
			place = request.getParameter("place"); 
		}
		int FTP = 0;
		if (!request.getParameter("FTP").isEmpty()) {
			FTP = Integer.parseInt(request.getParameter("FTP")); 
		}
		int howlong = 0;
		if (!request.getParameter("howlong").isEmpty()) {
			howlong = Integer.parseInt(request.getParameter("howlong")); 
		}
		String comment = "";
		if (!request.getParameter("comment").isEmpty()) {
			comment = request.getParameter("comment"); 
		}
		Person p = new Person();
		p.setUserName(name);
		p.setPassword(pass);
		p.setComment(comment);
		p.setPlace(place);
		p.setAge(age);
		p.setFTP(FTP);
		p.setHowlong(howlong);
		request.setAttribute("person", p);
		RequestDispatcher rd = request.getRequestDispatcher("/RegistConfirm.jsp");
		rd.forward(request, response);
	}

}
