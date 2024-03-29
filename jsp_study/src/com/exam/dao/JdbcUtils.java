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
		// 헤로쿠 MySQL DB
		// &useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		// 헤로쿠DB ID: : 까지
		// 헤로쿠DB PW: @ 까지
		// 헤로쿠 hostname : @ ~ /    // dbUrl의 localhost:3306 대체
		// 헤로쿠DB 스키마이름 : ? 까지
		
		// 만든 mysql
//		CREATE TABLE memeber (
//				id VARCHAR(50) PRIMARY KEY,
//				passwd VARCHAR(50) NOT NULL,
//				name VARCHAR(50) NOT NULL,
//				reg_date TIMESTAMP
//		);
		
//		INSERT INTO actor (first_name, last_name, last_update)
//		VALUES ('길동', '홍', now());

		Connection con = null;
		
		// ================================================================= Dao main함수 실행 할때 씀 --- 톰켓땜시
		// DB접속정보
//		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
//		String dbId = "myid";
//		String dbPwd = "mypwd";
//		
//		
//		
//		// 1단계. DB드라이버 클래스 로딩
//		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2단계. DB에 연결 시도. 연결후 Connection객체를 리턴함.
//		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		// =================================================================
		
		// Connection Pool 방식 - 커넥션 한개 빌려오기	
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jspdb");  // context.xml의 name속성값
		con = ds.getConnection(); // 커넥션 한개 빌려오기
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
