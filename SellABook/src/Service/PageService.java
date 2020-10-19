package Service;

import static DB.jdbcUtil.*;


import java.sql.Connection;
import java.util.List;

import DAO.*;
import DTO.*;

public class PageService {
	
	
	public int ListCount() {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int listCount = dao.ListCount();
		if (listCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return listCount;
	}

	public List<BookDTO> BookList(String category, int startRow, int endRow) {
		System.out.println("2. " +category);
		System.out.println("svc startRow : " + startRow);
		System.out.println("svc endRow : " + endRow);
		
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<BookDTO> bookList = dao.BookList(category, startRow, endRow);
		
	
		close(con);
		return bookList;
	}

}
