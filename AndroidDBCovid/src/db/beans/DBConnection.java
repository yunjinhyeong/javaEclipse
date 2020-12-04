package db.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() throws Exception {
		System.out.println("DB����õ�");
		Connection con = null;
		
		// ===============================================
		// DB��������
		String dbUrl = "jdbc:mysql://localhost:3306/androiddb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "androidDB";
		String dbPwd = "androidDB";
		
		// 1�ܰ�. DB����̹� Ŭ���� �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2�ܰ�. DB�� ���� �õ�. ������ Connection��ü�� ������.
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		// ===============================================
		
		// Ŀ�ؼ� Ǯ ���
//		Context context = new InitialContext();
//		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jspdb");
//		con = ds.getConnection(); // Ŀ�ؼ� �Ѱ� ��������
		return con;
	}
	
}
