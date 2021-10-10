package servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

/**
 * Servlet implementation class AddBoardServlet
 */
@WebServlet("/AddBoardServlet")
public class AddBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBoardServlet() {
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
		// TODO Auto-generated method stub
		String time = request.getParameter("time");
		String place = request.getParameter("place");
		String comment = request.getParameter("comment");
		int id = Integer.parseInt(request.getParameter("id"));// personのID
		BoardDao dao = new BoardDao();
		int count = dao.CountBoardde();
		count = count + 1;// 最終行のプラス1をboardid に設定する
		dao.AddInside(count);
		int result = dao.Addboard(count, time, place, comment, id);
		if (result == 1) {
			request.setAttribute("comment", "成功");
			RequestDispatcher rd = request.getRequestDispatcher("./CreateBoardSucseed.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("./error.jsp");
		}
	}

}
