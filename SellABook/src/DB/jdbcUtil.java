package DB;




import javax.naming.*;
import javax.sql.*;

import java.sql.*;



public class jdbcUtil {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
			
			con = ds.getConnection();
			con.setAutoCommit(false);
			System.out.println("DB立加 己傍");
		} catch (Exception e) {
			System.out.println("DB立加 角菩");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	//con close
	public static void close(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//statement close
	public static void close(Statement stmt) {
		try {
			stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//resultSet close
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// commit
	public static void commit(Connection con) {
		try {
			con.commit();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	//rollback
	public static void rollback(Connection con) {
		try {
			con.rollback();
		}catch(Exception e) {e.printStackTrace();}
	}
}
