package sqlST;

import java.sql.*;

public class Ex2 {

	public static void main(String[] args) {
		//delect ¹®
		
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		
		int actorID = 209;
		
		String sql="";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			sql="DELETE FROM actor WHERE actor_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, actorID);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
