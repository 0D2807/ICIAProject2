package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import DAO.SBSDAO;
import DTO.MembersDTO;

public class FindService {

	public List<String> getFindId(String mail) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<String> list= dao.getFindId(mail);
		
		return list;
	}

	public MembersDTO getFindPw(String id, String mail) {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MembersDTO result = dao.getFindPw(id,mail);
		
		return result;
	}

}
