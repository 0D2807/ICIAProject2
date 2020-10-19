package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;

import DAO.SBSDAO;

public class JoinService {

	public int join(String id, String pw, String mail, String name) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.join(id,pw,mail,name);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		close(con);
		
		return result;
	}

}
