package DAO;

import static DB.jdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.BookDTO;
import DTO.ReviewDTO;

public class CommentDAO {
	private static CommentDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static CommentDAO getInstance() {
		if (dao == null) {
			dao = new CommentDAO();
		}
		return dao;
	}
	
	
	public void setConnection(Connection con) {
		this.con = con;
	}


	public int setReview(String id, String content,int bNum) {
		
		String sql = "INSERT INTO REVIEW VALUES(?,?,?,SYSDATE)";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			pstmt.setString(2, id);
			pstmt.setString(3, content);
			result=pstmt.executeUpdate();
			
		}catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);}
		
		return result;
	}


	public List<ReviewDTO> getReview(int bNum) {
		// TODO Auto-generated method stub
		
		String sql="SELECT * FROM REVIEW WHERE NUM=? ORDER BY RDATE DESC";
		List<ReviewDTO> review = new ArrayList<ReviewDTO>();
		ReviewDTO dto = null;
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new ReviewDTO();
				dto.setNum(rs.getInt("NUM"));
				dto.setComment(rs.getString("CONTENT"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setDate(rs.getString("RDATE"));
				
				review.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		return review;
	}

	public int bookHit(int num) {
		String sql = "UPDATE BOOK SET BHIT = BHIT + 1 WHERE BNUM = ?";
		int hitResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			hitResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return hitResult;
	}


	public BookDTO bookDate(int num) {
		String sql = "SELECT * FROM BOOK WHERE BNUM = ?";
		BookDTO bookdata = null; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bookdata=new BookDTO();
				bookdata.setNum(rs.getInt("BNUM"));
				bookdata.setHit(rs.getInt("BHIT"));
				bookdata.setVideo(rs.getString("BVIDEO"));
				bookdata.setTitle(rs.getString("BTITLE"));
				bookdata.setContent(rs.getString("BCONTENT"));
				bookdata.setImage(rs.getString("BIMAGE"));
				bookdata.setCover(rs.getString("BCOVER"));
				bookdata.setPrice(rs.getInt("BPRICE"));
				bookdata.setSite(rs.getString("BSITE"));
				bookdata.setPublisher(rs.getString("BPUBLISHER"));
				bookdata.setGenre(rs.getString("BGENRE"));
				bookdata.setCategory(rs.getString("BCATEGORY"));
				bookdata.setComment(rs.getString("BCOMMENT"));
				bookdata.setWriter(rs.getString("BWRITER"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return bookdata;
	}






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

