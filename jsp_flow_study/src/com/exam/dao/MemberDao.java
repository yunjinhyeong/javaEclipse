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
	
	// ��Ŭ�� ���� ����
	private static MemberDao instance = new MemberDao();
	
	// �̰ɷ� �ܺ�����
	public static MemberDao getInstance() {
		return instance;
	}
	
	// �ܺ����� ��õ���� private��
	private MemberDao() {
	}
	
	private Connection getConnection() throws Exception {
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

		
		
		// DB��������
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		
		Connection con = null;
		
		// 1�ܰ�. DB����̹� Ŭ���� �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2�ܰ�. DB�� ���� �õ�. ������ Connection��ü�� ������.
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

	// ȸ������ 1�� insert�ϱ�
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
			// ���� �߻����ο� ������� ������ �����۾� ������.
			// try���Ͽ��� ���� ��ü�� �����ϴ� �۾��� �ַ� ��
			close(con, pstmt);
		}
	} // addMember()
	
	// �α��� Ȯ��
	// check�� -1 �̸� ���� ���̵�
	// check�� 0 �̸� �н����� Ʋ��
	// check�� 1 �̸� ���̵�, �н����� ��ġ
	public int userCheck(String id, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		
		int check = -1; // ���� ���̵� ���°����� �ʱ�ȭ
		
		try {
			con = getConnection();
			sql="SELECT passwd "
					+ "FROM member "
					+ "WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// rs�� ������(��) ������
			//			�н����� �� ������ check = 1 Ʋ���� check = 0
			// rs�� ������(��) ������ check = -1
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

	// ��ü ȸ����� ��������
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

	// Ư��id�� �ش��ϴ� ȸ�� 1�� ��������
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

	// Ư��id�� �ش��ϴ� ȸ���� �̸� �����ϱ�                id�� �ش�Ǵ� �̸� ���� ���� �̸��� �����ϱ�
	public void update(MemberVo memberVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "UPDATE member ";
			sql += "SET name = ?, age = ?, gender = ?, email = ? ";
			sql += "WHERE id = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVo.getName());
			pstmt.setInt(2, memberVo.getAge());
			pstmt.setString(3, memberVo.getGender());
			pstmt.setString(4, memberVo.getEmail());
			pstmt.setString(5, memberVo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ���� �߻����ο� ������� ������ �����۾� ������.
			// try���Ͽ��� ���� ��ü�� �����ϴ� �۾��� �ַ� ��
			close(con, pstmt);
		}
	} // addMember()

	// Ư��id�� �ش��ϴ� ȸ�� 1�� �����ϱ�
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

	// ��� ȸ�� �����ϱ�
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

		// MemberDao ��ü �غ�
		MemberDao memberDao = new MemberDao();

		memberDao.deleteAll();

		System.out.println("======== insert �׽�Ʈ =========");

		for (int i = 0; i < 5; i++) {
			MemberVo memberVo = new MemberVo("aaa" + i, "1234", "ȫ�浿" + i,11+i,"man","korea"+i+"@naver.com");
			memberDao.addMember(memberVo);
		}

		List<MemberVo> list = memberDao.getAllMembers();
		for (MemberVo memberVo : list) {
			System.out.println(memberVo);
		}

		System.out.println("======== getMemberById �׽�Ʈ =========");

		MemberVo memberVo = memberDao.getMemberById("aaa0");
		System.out.println(memberVo);

		System.out.println("======== update �׽�Ʈ =========");

		memberVo.setName("�̼���"); // ������ �̸��� ����
		memberDao.update(memberVo);

		MemberVo getMemberVo = memberDao.getMemberById("aaa0");
		System.out.println(getMemberVo);

		System.out.println("======== deleteById �׽�Ʈ =========");

//		memberDao.deleteById("aaa0");
//		
//		MemberVo getMemberVo2 = memberDao.getMemberById("aaa0");
//		System.out.println(getMemberVo2);

	} // main

}