package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;

import DAO.SBSDAO;

public class MemberService {


	public int viewBook(int num,String id) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.viewBook(num,id);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
	
		return result;
	}

	public int getViewBook(String id) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int viweBook = dao.getViewBook(id);
		
		close(con);
		return viweBook;
	}

}
