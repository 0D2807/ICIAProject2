package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import DAO.SBSDAO;
import DTO.NoticeDTO;

public class NoticeService {

	public List<NoticeDTO> getNoticeList() {
		SBSDAO dao = SBSDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<NoticeDTO> notice = dao.getNoticeList();
		
		close(con);
		return notice;
	}

}
