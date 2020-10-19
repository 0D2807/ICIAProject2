package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.JoinService;


@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public JoinController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(request.getParameter("joinId").equals("")||request.getParameter("joinPw").equals("")||request.getParameter("joinMail").equals("")||request.getParameter("joinName").equals("")) {
			out.println("<script> alert('회원가입 실패');window.history.back()</script>");
			
		}
		String id = request.getParameter("joinId");
		String pw = request.getParameter("joinPw");
		String mail = request.getParameter("joinMail");
		String name = request.getParameter("joinName");
		
		JoinService joinsvc = new JoinService(); 
		int result = joinsvc.join(id,pw,mail,name);
		
		
		if(result>0) {
			 out.println("<script>");
			 out.println("alert('회원가입 되었습니다.')");
			 out.println("location.href='Main.jsp'");
			 out.println("</script>");
		}else {
			
		}
		
	}
}
