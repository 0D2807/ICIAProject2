package Controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BookDTO;
import Service.SearchService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");
		
		SearchService searchsvc = new SearchService();
		List<BookDTO> bookList = searchsvc.search(searchCondition,search);
		
		if(bookList != null) {
			request.setAttribute("bookList", bookList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Search.jsp");
			
			dispatcher.forward(request,response);
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
