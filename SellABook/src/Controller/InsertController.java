package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Service.InsertService;


@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
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
		int size = 30*1024*1024;
		String savePath = "D:/asdf/SB/Semi_Project2/WebContent/Image";
		MultipartRequest multi = new MultipartRequest(request,savePath,size,"UTF-8",new DefaultFileRenamePolicy());
		
		String video = multi.getParameter("video");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String image = multi.getFilesystemName("image"); 
		String cover = multi.getFilesystemName("cover");
		int price = Integer.parseInt(multi.getParameter("price"));
		String site = multi.getParameter("site");
		String publisher = multi.getParameter("publisher");
		String genre = multi.getParameter("genre");
		String category = multi.getParameter("category");
		String comment = multi.getParameter("comment");
		String writer = multi.getParameter("writer");
		System.out.println(video+title+content+image+cover+price+site+publisher+genre+category+comment+writer);
		InsertService insertsvc= new InsertService();
		
		int result = insertsvc.insertBook(video,title,content,image,cover,price,site,publisher,genre,category,comment,writer);
		
		if(result>0) {
			response.sendRedirect("Writer.jsp");
		}
	}

}
