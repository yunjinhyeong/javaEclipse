package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtils {
	public static Connection getConnection() throws Exception {
		// ����� MySQL DB
		// &useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		// �����DB ID: : ����
		// �����DB PW: @ ����
		// ����� hostname : @ ~ /    // dbUrl�� localhost:3306 ��ü
		// �����DB ��Ű���̸� : ? ����
		
		// ���� mysql
//		CREATE TABLE memeber (
//				id VARCHAR(50) PRIMARY KEY,
//				passwd VARCHAR(50) NOT NULL,
//				name VARCHAR(50) NOT NULL,
//				reg_date TIMESTAMP
//		);
		
//		INSERT INTO actor (first_name, last_name, last_update)
//		VALUES ('�浿', 'ȫ', now());

		Connection con = null;
		
		// ================================================================= Dao main�Լ� ���� �Ҷ� �� --- ���϶���
		// DB��������
//		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
//		String dbId = "myid";
//		String dbPwd = "mypwd";
//		
//		
//		
//		// 1�ܰ�. DB����̹� Ŭ���� �ε�
//		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2�ܰ�. DB�� ���� �õ�. ������ Connection��ü�� ������.
//		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		// =================================================================
		
		// Connection Pool ��� - Ŀ�ؼ� �Ѱ� ��������	
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jspdb");  // context.xml�� name�Ӽ���
		con = ds.getConnection(); // Ŀ�ؼ� �Ѱ� ��������
		return con;
	} // getConnection()
	
	public static void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // close()
}
