package co.micol.mvc.board.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardsDAO dao = new BoardsDAO();
		//dao에서 돌려받을 리스트 생성
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		list = dao.selectList(); //실제 테이블에 접속해서 list를 가져옴
		request.setAttribute("list", list);
		String viewPage = "views/board/boardList.jsp"; //결과를 보여줄 페이지
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);//돌려줄 페이지, 권한을 줄때 request까지 주는것
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
