package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import entity.BoardInside;

/**
 * Servlet implementation class GoMessageBoardServlet
 */
@WebServlet("/GoMessageBoardServlet")
public class GoMessageBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoMessageBoardServlet() {
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
		int boardid = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		BoardDao dao = new BoardDao();
		List<BoardInside> list = dao.SerachBoard(boardid);
		request.setAttribute("list", list);
		request.setAttribute("name", name);
		RequestDispatcher rd = request.getRequestDispatcher("./MessageBoard.jsp");
		rd.forward(request, response);

	}

}
