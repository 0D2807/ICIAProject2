
package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.BookDTO;
import DTO.MembersDTO;
import Service.BookService;
import Service.LoginService;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
     
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		if(request.getParameter("loginId").equals("")||request.getParameter("loginPw").equals("")) {
			PrintWriter out = response.getWriter();
			 out.println("<script> window.history.back();</script>");
		}

		String id = request.getParameter("loginId");
		String pw = request.getParameter("loginPw");
		
		LoginService loginsvc = new LoginService();
		BookService booksvc = new BookService();
		MembersDTO member = loginsvc.login(id,pw);
		BookDTO book = new BookDTO();
		
		
		
	
		if(member != null) {
			HttpSession session = request.getSession();
			book = booksvc.getBook(member.getViewBook());
			request.setAttribute("viewBook", book);
			session.setAttribute("member", member);
			session.setAttribute("memberId",member.getId());
			session.setAttribute("view",member.getViewBook());
			response.sendRedirect("Login.jsp");
			
			
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호를 확인해주세요') window.history.back();</script>");
		}
	}

}
