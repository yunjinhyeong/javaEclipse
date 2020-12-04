package db.beans;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class QueryBean {
	Connection conn;	// 연결 객체
	Statement stmt;		// 질의 객체
	ResultSet rs;		// 결과 객체
	
	public QueryBean() {
		conn = null;
		stmt = null;
		rs = null;
	}
	
	public void getConnection() {
		try {
			conn = DBConnection.getConnection();			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
		try {
			stmt = conn.createStatement();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		if(stmt != null) {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList getUserInfo() throws Exception {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT ");
		sb.append(" id, name, pw, phone, writeTime, fever, cough, soreThroat, snot, phlegm, breathing, confirmation ");
		sb.append(" FROM ");
		sb.append(" userInfo ");
		sb.append(" ORDER BY ");
		sb.append(" writeTime ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
			res.add(rs.getString(5));
			res.add(rs.getString(6));
			res.add(rs.getString(7));
			res.add(rs.getString(8));
			res.add(rs.getString(9));
			res.add(rs.getString(10));
			res.add(rs.getString(11));
			res.add(rs.getString(12));
		}
		System.out.print(sb.toString());
		return res;
	}
	
	public ArrayList getUserInfo(String id) throws Exception {
		StringBuffer sb = new StringBuffer(); // 완성
		
		sb.append(" SELECT ");
		sb.append(" 	id, name, pw, phone, writeTime, fever, cough, soreThroat, snot, phlegm, breathing, confirmation ");
		sb.append(" FROM ");
		sb.append(" 	userInfo ");
		sb.append(" WHERE ");
		sb.append(" 	id like '%" + id + "%' ");
		sb.append(" ORDER BY ");
		sb.append(" 	writeTime ");
		sb.append(" DESC ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
			res.add(rs.getString(5));
			res.add(rs.getString(6));
			res.add(rs.getString(7));
			res.add(rs.getString(8));
			res.add(rs.getString(9));
			res.add(rs.getString(10));
			res.add(rs.getString(11));
			res.add(rs.getString(12));
		}
		System.out.println(sb.toString());
		return res;
	}
	
	public ArrayList getBoardInfo() throws Exception {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT ");
		sb.append(" id, subject, content, writeTime ");
		sb.append(" FROM ");
		sb.append(" board ");
		sb.append(" ORDER BY ");
		sb.append(" writeTime ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
		}
		System.out.print(sb.toString());
		return res;
	}
	
	public ArrayList getBoardInfo(String subject) throws Exception {
		StringBuffer sb = new StringBuffer(); // 완성
		
		sb.append(" SELECT ");
		sb.append(" 	id, subject, content, writeTime ");
		sb.append(" FROM ");
		sb.append(" 	board ");
		sb.append(" WHERE ");
		sb.append(" 	subject like '%" + subject + "%' ");
		sb.append(" ORDER BY ");
		sb.append(" 	writeTime ");
		sb.append(" DESC ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
		}
		System.out.println(sb.toString());
		return res;		
	}
	
	public int setUserInfo(String id, String name, String pw, String phone) { // 회원가입할때만 사용
		int result = 0; // 완성
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
//		sb.append(" INSERT INTO ");
//		sb.append(" 	USER_INFO_SAMPLE (U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME) ");
//		sb.append(" VALUES ");
//		sb.append(" 	('" + id + "', '"+ name + "', '" + phone + "', '" + grade + "', now())");
		
		sb.append(" INSERT INTO userInfo (id, name, pw, phone, writeTime) ");
		sb.append(" VALUES ('"+id+"', '"+name+"', '"+pw+"', '"+phone+"', now()) ");
				
		System.out.println(sb.toString());
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int setBoardInfo(String id, String subject, String content) { // 회원가입할때만 사용
		int result = 0; // 완성
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
//		sb.append(" INSERT INTO ");
//		sb.append(" 	USER_INFO_SAMPLE (U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME) ");
//		sb.append(" VALUES ");
//		sb.append(" 	('" + id + "', '"+ name + "', '" + phone + "', '" + grade + "', now())");
		
		sb.append(" INSERT INTO board (id, subject, content, writeTime) ");
		sb.append(" VALUES ('"+id+"', '"+subject+"', '"+content+"', now()) ");
				
		System.out.println(sb.toString());
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public int setUserInfo2(String id, String fever, String cough, String soreThroat, String snot, String phlegm, String breathing, String confirmation) { // 회원가입할때만 사용
		int result = 0; // 완성
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
//		sb.append(" INSERT INTO ");
//		sb.append(" 	USER_INFO_SAMPLE (U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME) ");
//		sb.append(" VALUES ");
//		sb.append(" 	('" + id + "', '"+ name + "', '" + phone + "', '" + grade + "', now())");
		
		sb.append(" UPDATE userinfo ");
		sb.append(" 	SET ");
		sb.append(" fever = '" + fever + "', cough = '" + cough + "', soreThroat = '" + soreThroat + "', snot = '" + snot + "', phlegm = '" + phlegm + "', breathing = '" + breathing + "', confirmation = '" + confirmation + "' ");
		sb.append(" 	WHERE ");
		sb.append(" 		id = '" + id + "' ");
				
		System.out.println(sb.toString());
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int getCountById(String id) {
		StringBuffer sb = new StringBuffer();
		int res = 0;
		
		sb.append(" SELECT ");
		sb.append(" 	COUNT(*) ");
		sb.append(" FROM ");
		sb.append(" 	userinfo ");
		sb.append(" WHERE ");
		sb.append(" 	id = '"+id+"' ");
		
		try {
			rs = stmt.executeQuery(sb.toString());
			if (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		return res;	
	}
	
	public int userLogin(String id, String pw) { // 로그인시
		StringBuffer sb = new StringBuffer(); // 완성
		
		int res = -1; // 없는 아이디 상태값으로 초기화
		
		sb.append(" SELECT ");
		sb.append(" 	pw ");
		sb.append(" FROM ");
		sb.append(" 	userinfo ");
		sb.append(" WHERE ");
		sb.append(" 	id = '"+id+"'  ");
		
		try {
			rs = stmt.executeQuery(sb.toString());
			if (rs.next()) {
				if(pw.equals(rs.getString("pw"))) {
					res = 1; // 맞으면
					
				} else {
					res = 0; // 틀리면
				}
			} else {
				res = -1; // 없으면
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		return res;	
	}
	
	public int setDiseaseInfo(String id, Boolean fever, Boolean cough, Boolean soreThroat, Boolean snot, Boolean phlegm, Boolean breathing	, Boolean confirmation) { // 질병정보 인설트
		int result = 0; // 완성
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
//		sb.append(" INSERT INTO ");
//		sb.append(" 	USER_INFO_SAMPLE (U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME) ");
//		sb.append(" VALUES ");
//		sb.append(" 	('" + id + "', '"+ name + "', '" + phone + "', '" + grade + "', now())");
		
		sb.append(" INSERT INTO userinfo (fever, cough, soreThroat, snot, phlegm, breathing, confirmation) ");
		sb.append(" VALUES (fever, cough, soreThroat, snot, phlegm, breathing, confirmation ");
		sb.append(" 	WHERE ");
		sb.append(" 		id = ? ");
				
		System.out.println(sb.toString());
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateUserInfo(String id, String name, String pw, String phone) { // 회원가입시 한 정보만 수정
		int result = 0; // 완성
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;		
		
		sb.append(" UPDATE userinfo ");
		sb.append(" 	SET ");
		sb.append(" name = '" + name + "', pw = '" + pw + "', phone = '" + phone + "' ");
		sb.append(" 	WHERE ");
		sb.append(" 		id = '" + id + "' ");
		
		System.out.println(sb.toString());
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateBoard(String id, String subject, String content) { // 
		int result = 0; // 완성
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;		
		
		sb.append(" UPDATE board ");
		sb.append(" 	SET ");
		sb.append(" subject = '" + subject + "', content = '" + content + "' ");
		sb.append(" 	WHERE ");
		sb.append(" 		id = '" + id + "' ");
		
		System.out.println(sb.toString());
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteUserInfo(String id) throws Exception {
		int result = 0; // 완성
		
		PreparedStatement pstmt = null;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" DELETE ");
		sb.append(" 	FROM ");
		sb.append(" 		userInfo ");
		sb.append(" 	WHERE ");
		sb.append(" 		id = ? ");		
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.clearParameters();
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteUserInfoBoard(String id, String subject, String writeTime) throws Exception {
		int result = 0; // 완성
		
		PreparedStatement pstmt = null;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" DELETE ");
		sb.append(" 	FROM ");
		sb.append(" 		board ");
		sb.append(" 	WHERE ");
		sb.append(" 		id = ? AND subject = ? AND writeTime = ? ");		
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.clearParameters();
			pstmt.setString(1, id);
			pstmt.setString(2, subject);
			pstmt.setString(3, writeTime);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
