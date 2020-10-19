package Service;

import static DB.jdbcUtil.close;
import static DB.jdbcUtil.commit;
import static DB.jdbcUtil.getConnection;
import static DB.jdbcUtil.rollback;

import java.sql.Connection;

import DAO.CommentDAO;
import DAO.SBSDAO;
import DTO.BookDTO;

public class ViewService {

	public BookDTO getView(int num) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		BookDTO dto = dao.getView(num);
		
		close(con);
		return dto;
	}
	public BookDTO viewResult(int num) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int bHit = dao.bookHit(num);
		if (bHit > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		BookDTO bookDate = dao.bookDate(num);
		close(con);
		return bookDate;
	}


}
