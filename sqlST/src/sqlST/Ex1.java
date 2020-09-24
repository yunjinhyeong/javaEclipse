package sqlST;

import java.sql.*;

public class Ex1 {

	public static void main(String[] args) {
		// insert
		
		//db접속정보
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		
		// insert 할 값
		String firstName = "가나";
		String lastName = "이";
		
		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			sql = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, now())";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
