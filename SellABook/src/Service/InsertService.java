package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;

import DAO.SBSDAO;

public class InsertService {

	public int insertBook(String video, String title, String content, String image, String cover, int price,
			String site, String publisher, String genre, String category, String comment, String writer) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result= dao.insertBook(video,title,content,image,cover,price,site,publisher,genre,category,comment,writer);
		
		
		if(result>0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
