package sqlST;

import java.sql.*;

public class Ex3 {

	public static void main(String[] args) {
		// update문
		// db셋팅
		
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		
		String lastName = "고";
		int actorId = 203;
		
		String sql="";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			sql = "UPDATE actor SET last_name = ? WHERE actor_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lastName);
			pstmt.setInt(2, actorId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
