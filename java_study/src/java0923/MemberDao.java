package java0923;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java0921.ActorVo;

public class MemberDao {
	// �ߺ��κ� ȣ���� �𿡰� �佺�ϱ�
	public Connection getConnection() throws Exception {
		// DB����
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";
		// ����
		Connection con = null;
		// 1�ܰ�. DB����̹� Ŭ���� �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2�ܰ�. DB�� ���� �õ�. ���� �� Connection��ü�� ������.
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
		return con;
	}

	// ��ü ȸ����� ��������
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

	// Ư��id�� �ش��ϴ� ȸ�� 1�� ��������
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

	// ȸ������ 1�� insert �ϱ�
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
			System.out.println(count + "�� �� �߰� ��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	

	// Ư��id�� �ش��ϴ� ȸ���� �̸� �����ϱ�
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

	// Ư��id�� �ش��ϴ� ȸ�� 1�� �����ϱ�
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
			System.out.println(count + "�� ���� ������.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	// ��� ȸ�� �����ϱ�
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
			System.out.println("��� �ɹ� ������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("============== ��ü ȸ����� �������� ��� =============");
		MemberDao memberDao = new MemberDao();
		List<MemberVo> list = memberDao.getMember();
		for(MemberVo member : list) {
			System.out.println(member.toString());
		}
		System.out.println("�ɹ��� �� : " + list.size());
		
		System.out.println("============== ȸ������ 1�� insert �ϱ� =============");
		//���õ�����
		MemberVo sampleMan = new MemberVo(3,"qet","qet");		
		//insert �׽�Ʈ
		memberDao.addMember(sampleMan);
		System.out.println(sampleMan);
		
		System.out.println("============== Ư��id�� �ش��ϴ� ȸ�� 1�� �������� =============");
		
		MemberVo memberVo1 = memberDao.getMemberById(sampleMan.getId());
		System.out.println("member id : "+ memberVo1);
		
		System.out.println("============== Ư��id�� �ش��ϴ� ȸ���� �̸� �����ϱ� =============");
		sampleMan.setName("�浿");
		memberDao.updateByName(sampleMan);
		System.out.println(sampleMan);
		
		System.out.println("============== Ư��id�� �ش��ϴ� ȸ�� 1�� �����ϱ� =============");
		memberDao.deleteMemberById(sampleMan.getId());
	
		System.out.println("============== ��� ȸ�� �����ϱ� =============");
		memberDao.deleteMemberAll();

	
	}

}
