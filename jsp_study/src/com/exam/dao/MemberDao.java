package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.vo.MemberVo;

public class MemberDao {

	private Connection getConnection() throws Exception {
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

		
		
		// DB접속정보
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		
		Connection con = null;
		
		// 1단계. DB드라이버 클래스 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2단계. DB에 연결 시도. 연결후 Connection객체를 리턴함.
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		return con;
	} // getConnection()

	private void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
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

	// 회원정보 1명 insert하기
	public void addMember(MemberVo memberVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "INSERT INTO member (id, passwd, name, age, gender, email, reg_date) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPasswd());
			pstmt.setString(3, memberVo.getName());
			pstmt.setInt(4, memberVo.getAge());
			pstmt.setString(5, memberVo.getGender());
			pstmt.setString(6, memberVo.getEmail());
			pstmt.setTimestamp(7, memberVo.getRegDate());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생여부에 관계없이 무조건 정리작업 수행함.
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
			close(con, pstmt);
		}
	} // addMember()
	
	// 로그인 확인
	// check가 -1 이면 없는 아이디
	// check가 0 이면 패스워드 틀림
	// check가 1 이면 아이디, 패스워드 일치
	public int userCheck(String id, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		
		int check = -1; // 없는 아이디 상태값으로 초기화
		
		try {
			con = getConnection();
			sql="SELECT passwd "
					+ "FROM member "
					+ "WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// rs에 데이터(행) 있으면
			//			패스워드 비교 맞으면 check = 1 틀리면 check = 0
			// rs에 데이터(행) 없으면 check = -1
			if(rs.next()) {
				if(passwd.equals(rs.getString("passwd"))) {
					check = 1;
					
				} else {
					check = 0;
				}
				
			} else {
				check = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return check;
	} //userCheck()

	// 전체 회원목록 가져오기
	public List<MemberVo> getAllMembers() {
		List<MemberVo> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			con = getConnection();

			sql = "SELECT * FROM member ORDER BY id";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setId(rs.getString("id"));
				memberVo.setPasswd(rs.getString("passwd"));
				memberVo.setName(rs.getString("name"));
				memberVo.setAge(rs.getInt("age"));
				memberVo.setGender(rs.getString("gender"));
				memberVo.setEmail(rs.getString("email"));
				memberVo.setRegDate(rs.getTimestamp("reg_date"));

				list.add(memberVo);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	} // getAllMembers()

	// 특정id에 해당하는 회원 1명 가져오기
	public MemberVo getMemberById(String id) {
		MemberVo memberVo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			con = getConnection();

			sql = "SELECT * FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberVo = new MemberVo();
				memberVo.setId(rs.getString("id"));
				memberVo.setPasswd(rs.getString("passwd"));
				memberVo.setName(rs.getString("name"));
				memberVo.setAge(rs.getInt("age"));
				memberVo.setGender(rs.getString("gender"));
				memberVo.setEmail(rs.getString("email"));
				memberVo.setRegDate(rs.getTimestamp("reg_date"));
			} // if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return memberVo;
	} // getMemberById()

	// 특정id에 해당하는 회원의 이름 수정하기
	public void update(MemberVo memberVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "UPDATE member ";
			sql += "SET name = ? ";
			sql += "WHERE id = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생여부에 관계없이 무조건 정리작업 수행함.
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
			close(con, pstmt);
		}
	} // addMember()

	// 특정id에 해당하는 회원 1명 삭제하기
	public void deleteById(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "DELETE FROM member WHERE id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	} // deleteById()

	// 모든 회원 삭제하기
	public void deleteAll() {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "DELETE FROM member ";
			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	} // deleteAll()

	public static void main(String[] args) {

		// MemberDao 객체 준비
		MemberDao memberDao = new MemberDao();

		memberDao.deleteAll();

		System.out.println("======== insert 테스트 =========");

		for (int i = 0; i < 5; i++) {
			MemberVo memberVo = new MemberVo("aaa" + i, "1234", "홍길동" + i,11+i,"man","korea"+i+"@naver.com");
			memberDao.addMember(memberVo);
		}

		List<MemberVo> list = memberDao.getAllMembers();
		for (MemberVo memberVo : list) {
			System.out.println(memberVo);
		}

		System.out.println("======== getMemberById 테스트 =========");

		MemberVo memberVo = memberDao.getMemberById("aaa0");
		System.out.println(memberVo);

		System.out.println("======== update 테스트 =========");

		memberVo.setName("이순신"); // 수정될 이름값 설정
		memberDao.update(memberVo);

		MemberVo getMemberVo = memberDao.getMemberById("aaa0");
		System.out.println(getMemberVo);

		System.out.println("======== deleteById 테스트 =========");

//		memberDao.deleteById("aaa0");
//		
//		MemberVo getMemberVo2 = memberDao.getMemberById("aaa0");
//		System.out.println(getMemberVo2);

	} // main

}
