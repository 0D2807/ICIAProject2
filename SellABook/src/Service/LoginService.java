package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;

import DAO.SBSDAO;
import DTO.MembersDTO;

public class LoginService {

	public MembersDTO login(String id, String pw) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		MembersDTO member = dao.login(id,pw);
		
		close(con);
		
		
		return member;
	}

}
