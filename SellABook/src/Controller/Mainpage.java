package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.BookDTO;
import Service.BestService;
import Service.BookService;
import Service.MemberService;
import Service.ViewService;

/**
 * Servlet implementation class Mainpage
 */
@WebServlet("/Mainpage")
public class Mainpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mainpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String category = request.getParameter("category");
		BestService bestsvc = new BestService();
		
		String id ="asdasdasdsa";
		if(session.getAttribute("memberId")!=null) {
	      id = (String)session.getAttribute("memberId");
		}
	      MemberService membersvc = new MemberService();
	      int viewBook =membersvc.getViewBook(id);
	      
	      
		   ViewService viewsvc = new ViewService();
		   BookDTO book = viewsvc.getView(viewBook);

		
		List<BookDTO> bestList = bestsvc.getBest(category);
			
		if(bestList!=null) {
			
			request.setAttribute("viewBook", book);
			request.setAttribute("category",category);
			request.setAttribute("bestList", bestList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Mainpage1.jsp");
			dispatcher.forward(request, response);
		}
	}

}
