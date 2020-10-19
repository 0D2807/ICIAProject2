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

import DTO.ReviewDTO;
import Service.MemberService;
import Service.ReviewService;
import Service.ViewService;


@WebServlet("/bookView")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
	
		int page =Integer.parseInt(request.getParameter("page"));
		
			String id = (String)session.getAttribute("memberId");
		
		
		ViewService viewsvc = new ViewService();
		MemberService membersvc = new MemberService();
		int result = membersvc.viewBook(num,id);
	
		

		BookDTO book = viewsvc.viewResult(num);	
		System.out.println(book.toString());
		ReviewService reviewsvc = new ReviewService();
		
		List<ReviewDTO> review = reviewsvc.getReview(num);
		request.setAttribute("review", review);
		request.setAttribute("book", book);
		request.setAttribute("page", page);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View.jsp");
		dispatcher.forward(request, response);
		
	
		
	
		
		
	}

	}


