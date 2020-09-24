package sqlST;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class testDao {
	
	private Connection getConnection() throws Exception {
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		return con;
	}
	
	private void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	} // try catch 중복방지
	
	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) {
			pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) {
			con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // try catch 중복방지

	// 회원정보 1명 insert하기
	public void insertMember(testVo testvo) {
		PreparedStatement pstmt = null;
		Connection con = null;
		try { // alt + shift + z
			con = getConnection();
			String sql = ""; // 훗날 쓰레드 같은게 도입시 외부에 선언할때보다 지역에 선언하는게 더 좋다
			sql = "insert into member (id, passwd, name, reg_date) values (?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, testvo.getId());
			pstmt.setString(2, testvo.getPasswd());
			pstmt.setString(3, testvo.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생여부에 관계없이 무조건 수행
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
			close(con, pstmt);
		}
	}

	// 전체 회원목록 가져오기
	public List<testVo> allMembers() {
		List<testVo> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = getConnection();
			sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				testVo testvo = new testVo();
				testvo.setId(rs.getString("id"));
				testvo.setPasswd(rs.getString("passwd"));
				testvo.setName(rs.getString("name"));
				testvo.setReg_time(rs.getTimestamp("reg_date"));

				list.add(testvo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 예외 발생여부에 관계없이 무조건 수행
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
			close(con, pstmt, rs);
		}
		return list;
	}

	// 특정id에 해당하는 회원 1명 가져오기
	public testVo getMember(String id) {
		testVo testvo = null; // = new testVo(); 안해주고 null해주는건 null값이 들어올때도 있으니깐
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = getConnection();
			sql = "select * from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 실무에선 while보단 if 어차피 왜냐면 한번만 실행되니깐
				testvo = new testVo();
				testvo.setId(rs.getString("id"));
				testvo.setPasswd(rs.getString("passwd"));
				testvo.setName(rs.getString("name"));
				testvo.setReg_time(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 예외 발생여부에 관계없이 무조건 수행
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
			close(con, pstmt, rs);
		}

		return testvo;
	}

	// 특정id에 해당하는 회원의 이름 수정하기
	public void updateMember(testVo testvo) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "";
		try {
			con = getConnection();
			sql = "update member set name = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, testvo.getName());
			pstmt.setString(2, testvo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 예외 발생여부에 관계없이 무조건 수행
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
			close(con, pstmt);
		}

	}

	// 특정id에 해당하는 회원 1명 삭제하기
	public void deleteMemberByID(String id) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "";		
		try {
			con = getConnection();
			sql = "delete from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 예외 발생여부에 관계없이 무조건 수행
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
			close(con, pstmt);
		}

	}

	// 모든 회원 삭제하기
	public void deleteAllMembers() {
		PreparedStatement pstmt = null;
		Connection con = null;
		String sql = "";
		try {
			con = getConnection();
			sql = "delete from member";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 예외 발생여부에 관계없이 무조건 수행
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
			close(con, pstmt);
		}

	}

	public static void main(String[] args) {
		testDao testdao = new testDao();
		testVo sampleMan = new testVo("1", "asd", "가나"); // 샘플 인간
		testdao.deleteAllMembers();
		System.out.println("=========== insert 테스트 =============");
		// for로
		for( int i = 0 ; i<10 ; i++ ) {
			testVo testvo = new testVo("aaa" + i,"1234","홍길동"+i);
			testdao.insertMember(testvo);
		}
		// 기존
		testdao.insertMember(sampleMan);
		System.out.println("=========== 전체 가져오기 =============");
		List<testVo> list = testdao.allMembers();
		for (testVo name : list) {
			System.out.println(name.toString());
		}
		System.out.println("============ 1명 가져오기 ============");
		testVo testvo = testdao.getMember(sampleMan.getId());
		System.out.println(testvo);
		System.out.println("============ 특정id에 해당하는 회원의 이름 수정하기 ============");
		sampleMan.setName("고길");
		testdao.updateMember(sampleMan);
		System.out.println(sampleMan);
		System.out.println("============ 특정id에 해당하는 회원 1명 삭제하기 ============");
		testdao.deleteMemberByID(sampleMan.getId());
		System.out.println("============ 전체 회원 삭제하기 ============");
		testdao.deleteAllMembers();
	}

}
