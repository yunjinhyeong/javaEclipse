package sqlST;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class testDao {
	String sql;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Connection getConnection() throws Exception {
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		return con;
	}
	// 회원정보 1명 insert하기
	public void insertMember(testVo testvo) {
		try { // alt + shift + z
			con = getConnection();
			sql = "insert into member (id, passwd, name, reg_date) values (?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, testvo.getId());
			pstmt.setString(2, testvo.getPasswd());
			pstmt.setString(3, testvo.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// try블록에서 만든 객체를 정리하는 작업을 주로 함
		}
	}
	// 전체 회원목록 가져오기
	public List<testVo> allMembers() {
		List<testVo> list = new ArrayList<>();
		try {
			con = getConnection();
			sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
		}
		return list;
	}
	// 특정id에 해당하는 회원 1명 가져오기
	public testVo getMember(String id) {
		testVo testvo = new testVo();
		try {
			con = getConnection();
			sql = "select * from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				testvo = new testVo();
				testvo.setId(rs.getString("id"));
				testvo.setPasswd(rs.getString("passwd"));
				testvo.setName(rs.getString("name"));
				testvo.setReg_time(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testvo;
	}
	// 특정id에 해당하는 회원의 이름 수정하기
	public void updateMember(testVo testvo) {
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
		}
		
	}
	// 특정id에 해당하는 회원 1명 삭제하기
	public void deleteMemberByID(String id) {
		try {
			con = getConnection();
			sql = "delete from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 모든 회원 삭제하기
	public void deleteAllMembers() {
		try {
			con = getConnection();
			sql = "delete from member";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		testDao testdao = new testDao();
		testVo sampleMan = new testVo("1","asd","가나"); // 샘플 인간
		testdao.insertMember(sampleMan);
		System.out.println("=========== 전체 가져오기 =============");
		List<testVo> list = testdao.allMembers();
		for(testVo name : list) {
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
