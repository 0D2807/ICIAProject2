package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.BookDTO;
import DTO.MembersDTO;
import DTO.NoticeDTO;

import static DB.jdbcUtil.*;



public class SBSDAO {
	private static SBSDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static SBSDAO getInstance() {
		if (dao == null) {
			dao = new SBSDAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	

    
	public int insertBook(String video, String title, String content, String image, String cover, int price,
			String site, String publisher, String genre, String category, String comment, String writer) {
		String sql = "INSERT INTO BOOK VALUES(BOOK_NUM.NEXTVAL,?,?,?,?,?,0,?,?,?,?,?,?,?)";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,video);
			pstmt.setString(2,title);
			pstmt.setString(3,content);
			pstmt.setString(4,image);
			pstmt.setString(5,cover);
			pstmt.setInt(6,price);
			pstmt.setString(7,site);
			pstmt.setString(8,publisher);
			pstmt.setString(9,genre);
			pstmt.setString(10,category);
			pstmt.setString(11,comment);
			pstmt.setString(12,writer);
			result=pstmt.executeUpdate();
			
		}catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);}
		
		return result;
	}

	public BookDTO getView(int num) {
		String sql = "SELECT * FROM BOOK WHERE BNUM = ?";
		BookDTO dto = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new BookDTO();
				dto.setNum(rs.getInt("BNUM"));
				dto.setVideo(rs.getString("BVIDEO"));
				dto.setTitle(rs.getString("BTITLE"));
				dto.setContent(rs.getString("BCONTENT"));
				dto.setImage(rs.getString("BIMAGE"));
				dto.setCover(rs.getString("BCOVER"));
				dto.setHit(rs.getInt("BHIT"));
				dto.setPrice(rs.getInt("BPRICE"));
				dto.setSite(rs.getString("BSITE"));
				dto.setPublisher(rs.getString("BPUBLISHER"));
				dto.setGenre(rs.getString("BGENRE"));
				dto.setCategory(rs.getString("BCATEGORY"));
				dto.setComment(rs.getString("BCOMMENT"));
				dto.setWriter(rs.getString("BWRITER"));
				
			}
		}catch(SQLException se) {se.printStackTrace();}
		return dto;
	}

	public List<NoticeDTO> getNoticeList() {
		String sql = "SELECT * FROM NOTICE ORDER BY NDATE DESC";
		List<NoticeDTO> notice = new ArrayList<NoticeDTO>();
		NoticeDTO dto = null;
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new NoticeDTO();
				dto.setContent(rs.getString("NCONTENT"));
				dto.setDate(rs.getString("NDATE"));
			
				notice.add(dto);
			}
			
		} catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);close(rs);}
		return notice;
	}
    //�쉶�썝媛��엯
	public int join(String id, String pw, String mail, String name) {
		String sql = "INSERT INTO MEMBERS VALUES(?,?,?,?,0,'')";
		int result = 0;
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, mail);
			
			result = pstmt.executeUpdate();
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}
    
	//濡쒓렇�씤
	public MembersDTO login(String id, String pw) {
		String sql ="SELECT * FROM MEMBERS WHERE ID = ? AND PASSWORD = ?";
		MembersDTO member =null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
	        pstmt.setString(2, pw);
	        
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	member = new MembersDTO();
	        	member.setId(rs.getString("ID"));
	        	member.setPassword(rs.getString("PASSWORD"));
	        	member.setName(rs.getString("NAME"));
	        	member.setEmail(rs.getString("EMAIL"));
	        	member.setPoint(rs.getInt("POINT"));
	        	member.setViewBook(rs.getInt("VIEWBOOK"));
	        }
		System.out.println(member.toString()); 	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return member;
	}

	public List<BookDTO> search(String searchCondition, String search) {
		search = "%" + search +"%";
		String sql="";
		if(searchCondition.equals("BTITLE")) {
			sql = "SELECT * FROM BOOK WHERE BTITLE LIKE ?";
		}
		else if(searchCondition.equals("BCATEGORY")) {
			sql = "SELECT * FROM BOOK WHERE BCATEGORY LIKE ?";
		}
		else if(searchCondition.equals("BCONTENT")) {
			sql = "SELECT * FROM BOOK WHERE BCONTENT LIKE ?";
		}
		else if(searchCondition.equals("BPUBLISHER")) {
			sql = "SELECT * FROM BOOK WHERE BPUBLISHER LIKE ?";
		}
		else if(searchCondition.equals("BWRITER")) {
			sql = "SELECT * FROM BOOK WHERE BWRITER LIKE ?";
		} 
		
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		
		BookDTO dto = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,search);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto = new BookDTO();
				dto.setNum(rs.getInt("BNUM"));
				dto.setVideo(rs.getString("BVIDEO"));
				dto.setTitle(rs.getString("BTITLE"));
				dto.setContent(rs.getString("BCONTENT"));
				dto.setImage(rs.getString("BIMAGE"));
				dto.setCover(rs.getString("BCOVER"));
				dto.setHit(rs.getInt("BHIT"));
				dto.setPrice(rs.getInt("BPRICE"));
				dto.setSite(rs.getString("BSITE"));
				dto.setPublisher(rs.getString("BPUBLISHER"));
				dto.setGenre(rs.getString("BGENRE"));
				dto.setCategory(rs.getString("BCATEGORY"));
				dto.setComment(rs.getString("BCOMMENT"));
				dto.setWriter(rs.getString("BWRITER"));

				bookList.add(dto);
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}

		
		return bookList;
	}

	public List<BookDTO> getBest(String category) {
		String sql = "SELECT * FROM BOOK WHERE BCATEGORY = ? ORDER BY BHIT DESC";
		List<BookDTO> bestList = new ArrayList<BookDTO>();
		BookDTO dto = null;
		int i =1;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				dto =new BookDTO();
				dto.setNum(rs.getInt("BNUM"));
				dto.setVideo(rs.getString("BVIDEO"));
				dto.setTitle(rs.getString("BTITLE"));
				dto.setContent(rs.getString("BCONTENT"));
				dto.setImage(rs.getString("BIMAGE"));
				dto.setCover(rs.getString("BCOVER"));
				dto.setHit(rs.getInt("BHIT"));
				dto.setPrice(rs.getInt("BPRICE"));
				dto.setSite(rs.getString("BSITE"));
				dto.setPublisher(rs.getString("BPUBLISHER"));
				dto.setGenre(rs.getString("BGENRE"));
				dto.setCategory(rs.getString("BCATEGORY"));
				dto.setComment(rs.getString("BCOMMENT"));
				dto.setWriter(rs.getString("BWRITER"));

				bestList.add(dto);
				i++;
				if(i==4) {
					break;
				}
			}
		}
		catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);close(rs);}		
		return bestList;
	}

	

	public int ListCount() {
		String sql = "SELECT COUNT(*) FROM BOOK";
		int listCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<BookDTO> BookList(String category, int startRow, int endRow) {
		System.out.println("3. " +category);
		System.out.println("svc startRow : " + startRow);
		System.out.println("svc endRow : " + endRow);
	
		String sql = "";
		if (category.equals("동화,유아")) {
			sql = "SELECT * FROM BOOKCHILD  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("만화")) {
			sql = "SELECT * FROM BOOKTOON  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("잡지")) {
			sql = "SELECT * FROM BOOKZINE  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("IT,과학")) {
			sql = "SELECT * FROM BOOKIT  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("소설")) {
			sql = "SELECT * FROM BOOKNOVEL  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("자기계발")) {
			sql = "SELECT * FROM BOOKDEVE  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("취미,건강")) {
			sql = "SELECT * FROM BOOKHH  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("경제")) {
			sql = "SELECT * FROM BOOKECONOMY  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("시,에세이")) {
			sql = "SELECT * FROM BOOKESSAY  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("종교,예술")) {
			sql = "SELECT * FROM BOOKART  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("교재,수험서")) {
			sql = "SELECT * FROM BOOKTEXT  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		} else if (category.equals("인문,역사")) {
			sql = "SELECT * FROM BOOKHISTORY  WHERE RN BETWEEN ? AND ? AND BCATEGORY = ?";
		}
		
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		BookDTO book = null;
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, category);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				book = new BookDTO();
				book.setNum(rs.getInt("BNUM"));
				book.setVideo(rs.getString("BVIDEO"));
				book.setTitle(rs.getString("BTITLE"));
				book.setContent(rs.getString("BCONTENT"));
				book.setImage(rs.getString("BIMAGE"));
				book.setCover(rs.getString("BCOVER"));
				book.setHit(rs.getInt("BHIT"));
				book.setPrice(rs.getInt("BPRICE"));
				book.setSite(rs.getString("BSITE"));
				book.setPublisher(rs.getString("BPUBLISHER"));
				book.setGenre(rs.getString("BGENRE"));
				book.setCategory(rs.getString("BCATEGORY"));
				book.setComment(rs.getString("BCOMMENT"));
				book.setWriter(rs.getString("BWRITER"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return bookList;
	}

	public BookDTO getInfo(String title) {
		String sql = "SELECT * FROM BOOK WHERE BTITLE = ?";
		BookDTO dto = null;
		int i=1;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				dto = new BookDTO();
				dto.setNum(rs.getInt("BNUM"));
				dto.setVideo(rs.getString("BVIDEO"));
				dto.setTitle(rs.getString("BTITLE"));
				dto.setContent(rs.getString("BCONTENT"));
				dto.setImage(rs.getString("BIMAGE"));
				dto.setCover(rs.getString("BCOVER"));
				dto.setHit(rs.getInt("BHIT"));
				dto.setPrice(rs.getInt("BPRICE"));
				dto.setSite(rs.getString("BSITE"));
				dto.setPublisher(rs.getString("BPUBLISHER"));
				dto.setGenre(rs.getString("BGENRE"));
				dto.setCategory(rs.getString("BCATEGORY"));
				dto.setComment(rs.getString("BCOMMENT"));
				dto.setWriter(rs.getString("BWRITER"));
				if(i==1) {break;}
			}
		}catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);close(rs);}
		return dto;
	}

	public List<BookDTO> searchAll(String searchCondition, String search) {
		search = "%"+search+"%";
		String sql="SELECT * FROM BOOK WHERE BWRITER LIKE ? or BTITLE LIKE ? or BCONTENT LIKE ? or BPUBLISHER LIKE ? or BCATEGORY LIKE ?";
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		BookDTO dto = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,search);
			pstmt.setString(2,search);
			pstmt.setString(3,search);
			pstmt.setString(4,search);
			pstmt.setString(5,search);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto = new BookDTO();
				dto.setNum(rs.getInt("BNUM"));
				dto.setVideo(rs.getString("BVIDEO"));
				dto.setTitle(rs.getString("BTITLE"));
				dto.setContent(rs.getString("BCONTENT"));
				dto.setImage(rs.getString("BIMAGE"));
				dto.setCover(rs.getString("BCOVER"));
				dto.setHit(rs.getInt("BHIT"));
				dto.setPrice(rs.getInt("BPRICE"));
				dto.setSite(rs.getString("BSITE"));
				dto.setPublisher(rs.getString("BPUBLISHER"));
				dto.setGenre(rs.getString("BGENRE"));
				dto.setCategory(rs.getString("BCATEGORY"));
				dto.setComment(rs.getString("BCOMMENT"));
				dto.setWriter(rs.getString("BWRITER"));
				searchList.add(dto);
			}
			
		}catch(SQLException se) {se.printStackTrace();} finally {close(pstmt);close(rs);}
		return searchList;
	}

	public int viewBook(int num, String id) {
		String sql="UPDATE MEMBERS SET VIEWBOOK = ? WHERE ID = ?";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			result=pstmt.executeUpdate();
			
		}catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);}
		return result;
	}

	public BookDTO getBook(int viewBook) {
			String sql ="SELECT * FROM BOOK WHERE BNUM = ?";
			BookDTO dto = null;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, viewBook);
				rs=pstmt.executeQuery();
				if(rs.next()) {
				dto = new BookDTO();
				dto.setNum(rs.getInt("BNUM"));
				dto.setVideo(rs.getString("BVIDEO"));
				dto.setTitle(rs.getString("BTITLE"));
				dto.setContent(rs.getString("BCONTENT"));
				dto.setImage(rs.getString("BIMAGE"));
				dto.setCover(rs.getString("BCOVER"));
				dto.setHit(rs.getInt("BHIT"));
				dto.setPrice(rs.getInt("BPRICE"));
				dto.setSite(rs.getString("BSITE"));
				dto.setPublisher(rs.getString("BPUBLISHER"));
				dto.setGenre(rs.getString("BGENRE"));
				dto.setCategory(rs.getString("BCATEGORY"));
				dto.setComment(rs.getString("BCOMMENT"));
				dto.setWriter(rs.getString("BWRITER"));
				}
			}catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);close(rs);}
		return  dto;
	}

	public int getViewBook(String id) {
		String sql = "SELECT VIEWBOOK FROM MEMBERS WHERE ID = ?";
		int result  = 0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("VIEWBOOK");
			}
					
					
		}catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);close(rs);}
		return result;
	}

	public List<String> getFindId(String mail) {
		String sql="SELECT ID FROM MEMBERS WHERE EMAIL = ?";
		List<String> list = new ArrayList<String>();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mail);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("ID"));
				
			}
		}catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);close(rs);}
		return list;
	}

	public MembersDTO getFindPw(String id, String mail) {
		String sql="SELECT * FROM MEMBERS WHERE ID =? AND EMAIL = ?";
		MembersDTO member = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, mail);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member = new MembersDTO();
	        	member.setId(rs.getString("ID"));
	        	member.setPassword(rs.getString("PASSWORD"));
	        	member.setName(rs.getString("NAME"));
	        	member.setEmail(rs.getString("EMAIL"));
	        	member.setPoint(rs.getInt("POINT"));
	        	member.setViewBook(rs.getInt("VIEWBOOK"));
			}
		}catch(SQLException se) {se.printStackTrace();}finally {close(pstmt);close(rs);}
		
		return member;
	}



}
