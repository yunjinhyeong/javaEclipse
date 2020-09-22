package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class Ex3 {

	public static void main(String[] args) {
		// select��

		// DB ��������
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		
		
		String sql = "";
		
		// SELECT�� ���࿡ �ʿ��� JDBC ��ü 3����
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select������ ����
		
		try {
			// 1�ܰ�. DB����̹� Ŭ���� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2�ܰ�. DB�� ���� �õ�. ���� �� Connection��ü�� ������.
			con = DriverManager.getConnection(dbUrl,dbId,dbPwd);
			
			// 3�ܰ�. sql���尴ü �غ�
			sql = "SELECT * FROM actor WHERE first_name LIKE 'B%' ORDER BY actor_id DESC";	
			pstmt = con.prepareStatement(sql);
			
			// ���� �� SELECT ����� ResultSet���� ����
			rs = pstmt.executeQuery(); // SELECT�� ����� executeQuery() ȣ��
			
			// 4�ܰ�. ResultSet ������ ������ ���  //next: ���� �ű�
			while (rs.next()) {
				int actorId = rs.getInt("actor_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Timestamp lastUpdate = rs.getTimestamp("last_update");
				
				System.out.print(actorId + "\t");
				System.out.print(firstName + "\t");
				System.out.print(lastName + "\t");
				System.out.println(lastUpdate + "\t");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
