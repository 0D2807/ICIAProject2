package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.MembersDTO;
import Service.FindService;

/**
 * Servlet implementation class findPwController
 */
@WebServlet("/findPwController")
public class findPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findPwController() {
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
		
		if(request.getParameter("findId").equals("")||request.getParameter("findMail").equals("")) {
			PrintWriter out = response.getWriter();
			 out.println("<script> window.history.back();</script>");
		}
		String id = request.getParameter("findId");
		String mail= request.getParameter("findMail");
		
		FindService findsvc = new FindService();
		
		MembersDTO result = findsvc.getFindPw(id,mail);
		
		if(result!=null) {
			request.setAttribute("member", result);
			RequestDispatcher dispatcher= request.getRequestDispatcher("FindResult.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}
