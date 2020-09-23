package java0921;

import java.sql.*;


public class exTest1 {

	public static void main(String[] args) {
		// select��
		// db�����Ͱ�������
		// Test
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		
		//�����ϱ�
		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			sql = "Select * FROM actor where first_name LIKE 'B%'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				int actId = rs.getInt("actor_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Timestamp lastUpdate = rs.getTimestamp("last_update");
				
				System.out.print(actId + "\t");
				System.out.print(firstName + "\t");
				System.out.print(lastName + "\t");
				System.out.println(lastUpdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
