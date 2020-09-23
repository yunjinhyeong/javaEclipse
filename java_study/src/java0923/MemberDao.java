package java0923;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java0921.ActorVo;

public class MemberDao {
	// 중복부분 호출한 놈에게 토스하기
	public Connection getConnection() throws Exception {
		// DB정보
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		// 셋팅
		Connection con = null;
		// 1단계. DB드라이버 클래스 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2단계. DB에 연결 시도. 연결 후 Connection객체를 리턴함.
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		return con;
	}

	// 전체 회원목록 가져오기
	public List<MemberVo> getMember() {
		List<MemberVo> list = new ArrayList<>();
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			sql = "SELECT * FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setId(rs.getInt("id"));
				memberVo.setPasswd(rs.getString("passwd"));
				memberVo.setName(rs.getString("name"));
				memberVo.setReg_date(rs.getTimestamp("reg_date"));
			
				list.add(memberVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	// 특정id에 해당하는 회원 1명 가져오기
	public MemberVo getMemberById(int memberId) {
		MemberVo memberVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		
		try {
			con = getConnection();
			sql = "SELECT * FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				memberVo = new MemberVo();
				memberVo.setId(rs.getInt("id"));
				memberVo.setPasswd(rs.getString("passwd"));
				memberVo.setName(rs.getString("name"));
				memberVo.setReg_date(rs.getTimestamp("reg_date"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberVo;
	}

	// 회원정보 1명 insert 하기
	public int addMember(MemberVo memberVo) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;		
		String sql="";
		
		try {
			con = getConnection();
			sql = "INSERT INTO member (id, passwd, name, reg_date) VALUES (?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPasswd());
			pstmt.setString(3, memberVo.getName());
			count = pstmt.executeUpdate();
			System.out.println(count + "개 행 추가 됨");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	

	// 특정id에 해당하는 회원의 이름 수정하기
	public void updateByName(MemberVo memberVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "UPDATE member SET name = ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVo.getName());
			pstmt.setInt(2, memberVo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 특정id에 해당하는 회원 1명 삭제하기
	public int deleteMemberById(int id) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "DELETE FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			count = pstmt.executeUpdate();
			System.out.println(count + "개 행이 삭제됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	// 모든 회원 삭제하기
	public int deleteMemberAll() {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			con = getConnection();
			sql = "DELETE FROM member";
			pstmt = con.prepareStatement(sql);
			count = pstmt.executeUpdate();
			System.out.println("모든 맴버 삭제됨");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("============== 전체 회원목록 가져오기 출력 =============");
		MemberDao memberDao = new MemberDao();
		List<MemberVo> list = memberDao.getMember();
		for(MemberVo member : list) {
			System.out.println(member.toString());
		}
		System.out.println("맴버의 수 : " + list.size());
		
		System.out.println("============== 회원정보 1명 insert 하기 =============");
		//샘플데이터
		MemberVo sampleMan = new MemberVo(3,"qet","qet");		
		//insert 테스트
		memberDao.addMember(sampleMan);
		System.out.println(sampleMan);
		
		System.out.println("============== 특정id에 해당하는 회원 1명 가져오기 =============");
		
		MemberVo memberVo1 = memberDao.getMemberById(sampleMan.getId());
		System.out.println("member id : "+ memberVo1);
		
		System.out.println("============== 특정id에 해당하는 회원의 이름 수정하기 =============");
		sampleMan.setName("길동");
		memberDao.updateByName(sampleMan);
		System.out.println(sampleMan);
		
		System.out.println("============== 특정id에 해당하는 회원 1명 삭제하기 =============");
		memberDao.deleteMemberById(sampleMan.getId());
	
		System.out.println("============== 모든 회원 삭제하기 =============");
		memberDao.deleteMemberAll();

	
	}

}
