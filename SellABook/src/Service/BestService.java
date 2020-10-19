package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import DAO.SBSDAO;
import DTO.BookDTO;

public class BestService {

	public List<BookDTO> getBest(String category) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<BookDTO> bookList = dao.getBest(category);
		
		close(con);
		return bookList;
	}

}
