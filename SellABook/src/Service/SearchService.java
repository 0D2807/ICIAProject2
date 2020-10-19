package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DAO.SBSDAO;
import DTO.BookDTO;

public class SearchService {

	public List<BookDTO> search(String searchCondition, String search) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
	
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		if(searchCondition.equals("검색조건")) {
			bookList = dao.searchAll(searchCondition,search);
			
		}
		else {
		bookList = dao.search(searchCondition,search);
		}
		
		close(con);
		
		return bookList;
	}

}
