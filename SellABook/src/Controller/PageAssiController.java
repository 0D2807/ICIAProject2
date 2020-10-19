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
import DTO.MembersDTO;
import DTO.PageDTO;
import Service.BookService;
import Service.PageService;

/**
 * Servlet implementation class PageAssiController
 */
@WebServlet("/PageAssi")
public class PageAssiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAssiController() {
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
		response.setContentType("text/html; charset=UTF-8");
		
		int page  = 1;
		int limit = 5;
//		page �뙆�씪誘명꽣 媛� 寃��궗
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		PageService pagesvc = new PageService();
		// �쟾泥� 寃뚯떆湲� 媛��닔瑜� 媛��졇�삤湲� �쐞�븳 PageService�쓽 ListCount硫붿냼�뱶 �샇異� 
		int listCount = pagesvc.ListCount();
//		pagesvc.ListCount() = 36; �뵲�씪�꽌 listCount = 36;
		
//		limit 媛믪쓣 嫄몄뼱�넃�� 留뚰겮 踰붿쐞�뿉 �빐�떦�븯�뒗 湲�留� 媛��졇�삤�뒗 諛⑸쾿
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		String category1 = request.getParameter("category1");
		System.out.println("category = " + category1);
		HttpSession session = request.getSession();
		
		
		
		MembersDTO member = new MembersDTO();
		
	
//		BookDTO category = new BookDTO();
//		category.setCategory("category1");
//		category.setCategory("category2");
//		System.out.println("1. " + category1);
//		startRow = 1
//		endRow = 3
		
		List<BookDTO> bookList = pagesvc.BookList(category1,startRow, endRow);
		
		// 理쒕�濡� �븘�슂�븳 �럹�씠吏� 媛��닔 怨꾩궛
		int maxPage = (int)((double)listCount / limit + 0.9);
		
		// �쁽�옱 �럹�씠吏��뿉 蹂댁뿬以� �떆�옉�럹�씠吏�
		int startPage = (((int)((double)page / 10 + 0.9))-1)*10+1;
		
		// �쁽�옱 �럹�씠吏��뿉 蹂댁뿬以� �걹 �럹�씠吏�
		int endPage = startPage + 5 -1;
		
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO paging = new PageDTO();
		
		String title= request.getParameter("title");
		BookService booksvc= new BookService();
		BookDTO book = booksvc.getInfo(title);
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setListCount(listCount);
		System.out.println(paging.toString());
		request.setAttribute("book", book);
		request.setAttribute("paging", paging);
		request.setAttribute("bookList", bookList);
		request.setAttribute("category",category1 );
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList1.jsp");
		dispatcher.forward(request, response);
		
	}

}
