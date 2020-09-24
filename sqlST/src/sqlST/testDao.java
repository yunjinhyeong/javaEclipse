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
	} // try catch �ߺ�����
	
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
	} // try catch �ߺ�����

	// ȸ������ 1�� insert�ϱ�
	public void insertMember(testVo testvo) {
		PreparedStatement pstmt = null;
		Connection con = null;
		try { // alt + shift + z
			con = getConnection();
			String sql = ""; // �ʳ� ������ ������ ���Խ� �ܺο� �����Ҷ����� ������ �����ϴ°� �� ����
			sql = "insert into member (id, passwd, name, reg_date) values (?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, testvo.getId());
			pstmt.setString(2, testvo.getPasswd());
			pstmt.setString(3, testvo.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ���� �߻����ο� ������� ������ ����
			// try��Ͽ��� ���� ��ü�� �����ϴ� �۾��� �ַ� ��
			close(con, pstmt);
		}
	}

	// ��ü ȸ����� ��������
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
			// ���� �߻����ο� ������� ������ ����
			// try��Ͽ��� ���� ��ü�� �����ϴ� �۾��� �ַ� ��
			close(con, pstmt, rs);
		}
		return list;
	}

	// Ư��id�� �ش��ϴ� ȸ�� 1�� ��������
	public testVo getMember(String id) {
		testVo testvo = null; // = new testVo(); �����ְ� null���ִ°� null���� ���ö��� �����ϱ�
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
			if (rs.next()) { // �ǹ����� while���� if ������ �ֳĸ� �ѹ��� ����Ǵϱ�
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
			// ���� �߻����ο� ������� ������ ����
			// try��Ͽ��� ���� ��ü�� �����ϴ� �۾��� �ַ� ��
			close(con, pstmt, rs);
		}

		return testvo;
	}

	// Ư��id�� �ش��ϴ� ȸ���� �̸� �����ϱ�
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
			// ���� �߻����ο� ������� ������ ����
			// try��Ͽ��� ���� ��ü�� �����ϴ� �۾��� �ַ� ��
			close(con, pstmt);
		}

	}

	// Ư��id�� �ش��ϴ� ȸ�� 1�� �����ϱ�
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
			// ���� �߻����ο� ������� ������ ����
			// try��Ͽ��� ���� ��ü�� �����ϴ� �۾��� �ַ� ��
			close(con, pstmt);
		}

	}

	// ��� ȸ�� �����ϱ�
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
			// ���� �߻����ο� ������� ������ ����
			// try��Ͽ��� ���� ��ü�� �����ϴ� �۾��� �ַ� ��
			close(con, pstmt);
		}

	}

	public static void main(String[] args) {
		testDao testdao = new testDao();
		testVo sampleMan = new testVo("1", "asd", "����"); // ���� �ΰ�
		testdao.deleteAllMembers();
		System.out.println("=========== insert �׽�Ʈ =============");
		// for��
		for( int i = 0 ; i<10 ; i++ ) {
			testVo testvo = new testVo("aaa" + i,"1234","ȫ�浿"+i);
			testdao.insertMember(testvo);
		}
		// ����
		testdao.insertMember(sampleMan);
		System.out.println("=========== ��ü �������� =============");
		List<testVo> list = testdao.allMembers();
		for (testVo name : list) {
			System.out.println(name.toString());
		}
		System.out.println("============ 1�� �������� ============");
		testVo testvo = testdao.getMember(sampleMan.getId());
		System.out.println(testvo);
		System.out.println("============ Ư��id�� �ش��ϴ� ȸ���� �̸� �����ϱ� ============");
		sampleMan.setName("���");
		testdao.updateMember(sampleMan);
		System.out.println(sampleMan);
		System.out.println("============ Ư��id�� �ش��ϴ� ȸ�� 1�� �����ϱ� ============");
		testdao.deleteMemberByID(sampleMan.getId());
		System.out.println("============ ��ü ȸ�� �����ϱ� ============");
		testdao.deleteAllMembers();
	}

}
