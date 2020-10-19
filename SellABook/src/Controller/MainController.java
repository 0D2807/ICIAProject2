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
import Service.MemberService;
import Service.ViewService;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
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
      request.setCharacterEncoding("UTF-8");
      
      String id="";
      HttpSession session = request.getSession();
      if(session.getAttribute("memberId")!=null) {
    	  
      
    	  id = (String)session.getAttribute("memberId");
      }
      MemberService membersvc = new MemberService();
      int viewBook =membersvc.getViewBook(id);
      
      
	   ViewService viewsvc = new ViewService();
	   BookDTO book = viewsvc.getView(viewBook);
      
	   String category = "만화";
	   BestService bestsvc = new BestService();
	   List<BookDTO> bestList = bestsvc.getBest(category);
	  
	 
	   	
	   
	
	
	
	   
      if(book !=null) {
    	 request.setAttribute("bestList", bestList);
    	 request.setAttribute("viewBook", book);
    	 RequestDispatcher dispatcher = request.getRequestDispatcher("Main.jsp");
    	 dispatcher.forward(request, response);
      } 
      else {
    	  
    	  request.setAttribute("bestList", bestList);
    	  
    	  RequestDispatcher dispatcher = request.getRequestDispatcher("Main.jsp");
    	  dispatcher.forward(request, response); 
      }
      
      
      
      
      
      
      
      
      
      
		 
	}
}