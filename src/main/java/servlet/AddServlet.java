package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import entity.Person;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("name");
		String pass = request.getParameter("pass");
		//String name = request.getParameter("name");
		String age = request.getParameter("age");
		String place = request.getParameter("place");
		String ftp = request.getParameter("FTP");
		String howlong = request.getParameter("howlong");
		String comment = request.getParameter("comment");
		Person person = new Person();
		person.setAge(age);
		person.setComment(comment);
		person.setFTP(ftp);
		person.setHowlong(howlong);
		//person.setName(name);
		person.setPassword(pass);
		person.setPlace(place);
		person.setUserName(username);
		LoginDao dao = new LoginDao();
		int result1 = dao.AddLogin1(username, pass);
		int result2 = dao.AddPerson(person);
		if ((result1 == 1) & (result2 == 1)) {
			RequestDispatcher rd = request.getRequestDispatcher("/AddSucseed.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("./ErrorPage.jsp");
		}
	}

}
