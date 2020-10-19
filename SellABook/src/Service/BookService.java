package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;

import DAO.SBSDAO;
import DTO.BookDTO;

public class BookService {
	
	public BookDTO getInfo(String title) {
	SBSDAO dao = SBSDAO.getInstance();
	Connection con = getConnection();
	dao.setConnection(con);
	
	BookDTO book = dao.getInfo(title);
	if (book != null) {
		commit(con);
	} else {
		rollback(con);
	}
	close(con);
		return book;
	}

	public BookDTO getBook(int viewBook) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		BookDTO book = dao.getBook(viewBook);
		
		close(con);
		return book;
	}
}
