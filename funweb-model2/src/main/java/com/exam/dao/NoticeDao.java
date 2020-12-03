package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.exam.vo.NoticeVo;

public class NoticeDao {
	// �̱���
	private static NoticeDao instance = new NoticeDao();
	
	public static NoticeDao getInstance() {
		return instance;
	}
	/////////////

	private NoticeDao() {}
	
	
	// �ֱ۾��� �޼���
	public void addNotice(NoticeVo noticeVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "INSERT INTO notice (id, subject, content, readcount, reg_date, ip, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeVo.getId());
			pstmt.setString(2, noticeVo.getSubject());
			pstmt.setString(3, noticeVo.getContent());
			pstmt.setInt(4, noticeVo.getReadcount());
			pstmt.setTimestamp(5, noticeVo.getRegDate());
			pstmt.setString(6, noticeVo.getIp());
			pstmt.setInt(7, noticeVo.getReRef());
			pstmt.setInt(8, noticeVo.getReLev());
			pstmt.setInt(9, noticeVo.getReSeq());
			// ����
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // addBoard()
	
	
	public NoticeVo getNoticeByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		NoticeVo noticeVo = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT * FROM notice WHERE num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				noticeVo = new NoticeVo();
				
				noticeVo.setNum(rs.getInt("num"));
				noticeVo.setId(rs.getString("id"));
				noticeVo.setSubject(rs.getString("subject"));
				noticeVo.setContent(rs.getString("content"));
				noticeVo.setReadcount(rs.getInt("readcount"));
				noticeVo.setRegDate(rs.getTimestamp("reg_date"));
				noticeVo.setIp(rs.getString("ip"));
				noticeVo.setReRef(rs.getInt("re_ref"));
				noticeVo.setReLev(rs.getInt("re_lev")); 
				noticeVo.setReSeq(rs.getInt("re_seq"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return noticeVo;
	} // getNoticeByNum()
	
	
	public void updateReadcount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "UPDATE notice ";
			sql += "SET readcount = readcount + 1 ";
			sql += "WHERE num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // updateReadcount()
	
	
	// ��ü�۰��� ��������
	public int getCountAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT COUNT(*) FROM notice";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return count;
	} // getCountAll()
	
	
	// �˻�� ������ �۰��� ��������
	public int getCountBySearch(String category, String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "SELECT COUNT(*) FROM notice ";
			
			// ���� sql ����
			if (category.equals("subject")) {
				sql += "WHERE subject LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("content")) {
				sql += "WHERE content LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("id")) {
				sql += "WHERE id LIKE CONCAT('%', ?, '%') ";
			}
			
			pstmt = con.prepareStatement(sql);
			
			if (!category.equals("")) { // �˻�� ������
				pstmt.setString(1, search);  // ����ǥ�� �˻��� ����
			}
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return count;
	} // getCountBySearch()
	
	
	public List<NoticeVo> getNotices(int startRow, int pageSize) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<NoticeVo> list = new ArrayList<>();
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "SELECT * ";
			sql += "FROM notice ";
			sql += "ORDER BY re_ref DESC, re_seq ASC ";
			sql += "LIMIT ?, ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setNum(rs.getInt("num"));
				noticeVo.setId(rs.getString("id"));
				noticeVo.setSubject(rs.getString("subject"));
				noticeVo.setContent(rs.getString("content"));
				noticeVo.setReadcount(rs.getInt("readcount"));
				noticeVo.setRegDate(rs.getTimestamp("reg_date"));
				noticeVo.setIp(rs.getString("ip"));
				noticeVo.setReRef(rs.getInt("re_ref"));
				noticeVo.setReLev(rs.getInt("re_lev")); 
				noticeVo.setReSeq(rs.getInt("re_seq"));
				
				list.add(noticeVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return list;
	} // getNotices()
	
	
	public List<NoticeVo> getNoticesBySearch(int startRow, int pageSize, String category, String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<NoticeVo> list = new ArrayList<>();
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "SELECT * ";
			sql += "FROM notice ";
			// ���� sql ����
			if (category.equals("subject")) {
				sql += "WHERE subject LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("content")) {
				sql += "WHERE content LIKE CONCAT('%', ?, '%') ";
			} else if (category.equals("id")) {
				sql += "WHERE id LIKE CONCAT('%', ?, '%') ";
			}
			sql += "ORDER BY re_ref DESC, re_seq ASC ";
			sql += "LIMIT ?, ? ";
			
			pstmt = con.prepareStatement(sql);
			
			if (!category.equals("")) { // �˻�� ������
				pstmt.setString(1, search);  // ����ǥ�� �˻��� ����
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, pageSize);
			} else { // �˻�� ������
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, pageSize);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setNum(rs.getInt("num"));
				noticeVo.setId(rs.getString("id"));
				noticeVo.setSubject(rs.getString("subject"));
				noticeVo.setContent(rs.getString("content"));
				noticeVo.setReadcount(rs.getInt("readcount"));
				noticeVo.setRegDate(rs.getTimestamp("reg_date"));
				noticeVo.setIp(rs.getString("ip"));
				noticeVo.setReRef(rs.getInt("re_ref"));
				noticeVo.setReLev(rs.getInt("re_lev")); 
				noticeVo.setReSeq(rs.getInt("re_seq"));
				
				list.add(noticeVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return list;
	} // getNoticesBySearch()
	
	
	
	public void updateBoard(NoticeVo noticeVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql  = "UPDATE notice ";
			sql += "SET subject = ?, content = ? ";
			sql += "WHERE num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeVo.getSubject());
			pstmt.setString(2, noticeVo.getContent());
			pstmt.setInt(3, noticeVo.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // updateBoard
	
	
	
	public void deleteNoticeByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "DELETE FROM notice WHERE num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteNoticeByNum
	
	
	public void deleteAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "DELETE FROM notice";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // deleteAll
	
	
	// ��۾��� �޼���
	public boolean updateAndAddReply(NoticeVo noticeVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			con.setAutoCommit(false); // ����Ŀ������ ����
			
			sql  = "UPDATE notice ";
			sql += "SET re_seq = re_seq + 1 ";
			sql += "WHERE re_ref = ? ";
			sql += "AND re_seq > ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noticeVo.getReRef());
			pstmt.setInt(2, noticeVo.getReSeq());
			// update ����
			pstmt.executeUpdate();
			// update������ ���� pstmt ��ü �ݱ�
			pstmt.close();
			
			sql  = "INSERT INTO notice (id, subject, content, readcount, reg_date, ip, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeVo.getId());
			pstmt.setString(2, noticeVo.getSubject());
			pstmt.setString(3, noticeVo.getContent());
			pstmt.setInt(4, noticeVo.getReadcount());
			pstmt.setTimestamp(5, noticeVo.getRegDate());
			pstmt.setString(6, noticeVo.getIp());
			pstmt.setInt(7, noticeVo.getReRef());  // ���� �׷�
			pstmt.setInt(8, noticeVo.getReLev() + 1); // ��۾��� ������ �鿩���� + 1
			pstmt.setInt(9, noticeVo.getReSeq() + 1); // ��۾��� ������ �׷쳻 ���� + 1

			// insert�� ����
			pstmt.executeUpdate();
			
			con.commit(); // Ŀ���ϱ�
			
			con.setAutoCommit(true); // �ڵ�Ŀ���� �⺻���� true�� ����
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback(); // �����۾��� ������ ����� �ѹ�(��ü���)�ϱ� 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			return false;
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // updateAndAddReply
	
	
	
	
	public static void main(String[] args) {
		
		NoticeDao noticeDao = NoticeDao.getInstance();
		
		noticeDao.deleteAll(); // ���̺� ���� ��� ����
		
		// �ֱ� 1000�� insert�ϱ�
		for (int i=0; i<1000; i++) {
			NoticeVo noticeVo = new NoticeVo();

			noticeVo.setId("user1");
			noticeVo.setSubject("������" + i);
			noticeVo.setContent("�۳���" + i);
			noticeVo.setReadcount(0);
			noticeVo.setRegDate(new Timestamp(System.currentTimeMillis()));
			noticeVo.setIp("127.0.0.1");
			noticeVo.setReRef(JdbcUtils.getNextNum("notice"));
			noticeVo.setReLev(0);
			noticeVo.setReSeq(0);
			
			System.out.println(noticeVo);
			
			noticeDao.addNotice(noticeVo);
		} // for
		
		int count = noticeDao.getCountAll();
		System.out.println("count = " + count);
		
	} // main()
	
}
