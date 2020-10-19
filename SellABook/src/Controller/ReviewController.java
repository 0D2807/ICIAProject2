package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ReviewDTO;
import Service.ReviewService;


@WebServlet("/CommentController")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewController() {
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
		String content = request.getParameter("commentText");
		String id = request.getParameter("id");
		int bNum = Integer.parseInt(request.getParameter("bookNum"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		ReviewService reviewsvc = new ReviewService();
		
		int result =reviewsvc.setReview(id,content,bNum);
		
	
		
		if(result>0) {

			request.setAttribute("num", bNum);
			request.setAttribute("page", page);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ReviewTest.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
