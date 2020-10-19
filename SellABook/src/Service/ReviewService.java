package Service;

import static DB.jdbcUtil.close;
import static DB.jdbcUtil.commit;
import static DB.jdbcUtil.getConnection;
import static DB.jdbcUtil.rollback;

import java.sql.Connection;
import java.util.List;

import DAO.CommentDAO;
import DTO.ReviewDTO;

public class ReviewService {

	

	public int setReview(String id, String content,int bNum) {
		// TODO Auto-generated method stub
		
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.setReview(id, content,bNum);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public List<ReviewDTO> getReview(int bNum) {
		// TODO Auto-generated method stub
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ReviewDTO> review = dao.getReview(bNum);
		
		close(con);
		return review;
	}

	

}
