package com.exam.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.exam.vo.BoardVo;

public class BoardDao {
	// �̱���
	private static BoardDao instance = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return instance;}
	
	public int getNextNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int nextNum = 0;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			sql = "select ifnull(max(num),0)+1 AS next_num from board;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nextNum = rs.getInt("next_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return nextNum;
	} //getNextNum()
	
	public void addBoard(BoardVo boardVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			sql = "INSERT INTO board (num, name, passwd, subject, content, readcount, reg_date, ip, file, re_ref, re_lev, re_seq) ";
			sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardVo.getNum());
			pstmt.setString(2, boardVo.getName());
			pstmt.setString(3, boardVo.getPasswd());
			pstmt.setString(4, boardVo.getSubject());
			pstmt.setString(5, boardVo.getContent());
			pstmt.setInt(6, boardVo.getReadcount());
			pstmt.setTimestamp(7, boardVo.getRegDate());
			pstmt.setString(8, boardVo.getIp());
			pstmt.setString(9, boardVo.getFile());
			pstmt.setInt(10, boardVo.getReRef());
			pstmt.setInt(11, boardVo.getReLev());
			pstmt.setInt(12, boardVo.getReSeq());
			// ����
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	} // addBoard()
	
	public BoardVo getBoardByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVo boardVo = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			sql = "SELECT * FROM board WHERE num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				boardVo = new BoardVo();
				
				boardVo.setNum(rs.getInt("num")); // ""�ȿ� ���� ��ũ��ġ �� �ִ� ������
				boardVo.setName(rs.getString("name"));
				boardVo.setPasswd(rs.getString("passwd"));
				boardVo.setSubject(rs.getString("subject"));
				boardVo.setContent(rs.getString("content"));
				boardVo.setReadcount(rs.getInt("readcount"));
				boardVo.setRegDate(rs.getTimestamp("reg_date"));
				boardVo.setIp(rs.getString("ip"));
				boardVo.setFile(rs.getString("file"));
				boardVo.setReRef(rs.getInt("re_ref"));
				boardVo.setReLev(rs.getInt("re_lev")); 
				boardVo.setReSeq(rs.getInt("re_seq"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		
		return boardVo;
	} // getBoardByNum()
	
	public void updateReadcount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;		
		String sql ="";
		
		try {
			con = JdbcUtils.getConnection();
			sql = "UPDATE board ";
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
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		String sql ="";
		int count = 0;
		
		try {
			con=JdbcUtils.getConnection();
			sql = "select count(*) from board;";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		return count;
	} // getCount()
	
	public List<BoardVo> getBoards(int startRow, int pageSize) {
		Connection con = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		String sql ="";
		
		List<BoardVo> list = new ArrayList<>();
		
		try {
			con = JdbcUtils.getConnection();
			sql="select * from board order by re_ref desc, re_seq asc limit ?, ?;";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setNum(rs.getInt("num"));
				boardVo.setName(rs.getString("name"));
				boardVo.setPasswd(rs.getString("passwd"));
				boardVo.setSubject(rs.getString("subject"));
				boardVo.setContent(rs.getString("content"));
				boardVo.setReadcount(rs.getInt("readcount"));
				boardVo.setRegDate(rs.getTimestamp("reg_date"));
				boardVo.setIp(rs.getString("ip"));
				boardVo.setFile(rs.getString("file"));
				boardVo.setReRef(rs.getInt("re_ref"));
				boardVo.setReLev(rs.getInt("re_lev"));
				boardVo.setReSeq(rs.getInt("re_seq"));
				
				list.add(boardVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		
		return list;
	} // getBoard()
	
	// �۹�ȣ�� �ش��ϴ� �н����� ��ġ���� Ȯ���ϱ�
		public boolean isPasswdOk(int num, String passwd) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			boolean isPasswdOk = false;
			String sql = "";
			
			try {
				con = JdbcUtils.getConnection();
				// count�� �ִ��� ������ Ȯ��
				sql  = "SELECT COUNT(*) ";
				sql += "FROM board ";
				sql += "WHERE num = ? ";
				sql += "AND passwd = ? ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, passwd);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					int count = rs.getInt(1);
					if (count == 1) {
						isPasswdOk = true;
					} else {
						isPasswdOk = false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.close(con, pstmt, rs);
			}
			return isPasswdOk;
		} // isPasswdOk()
		
		public void updateBoard(BoardVo boardVo) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			String sql = "";
			
			try {
				con = JdbcUtils.getConnection();
				
				sql  = "UPDATE board ";
				sql += "SET name = ?, subject = ?, content = ?, file = ? ";
				sql += "WHERE num = ? ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, boardVo.getName());
				pstmt.setString(2, boardVo.getSubject());
				pstmt.setString(3, boardVo.getContent());
				pstmt.setString(4, boardVo.getFile());
				pstmt.setInt(5, boardVo.getNum());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.close(con, pstmt);
			}
		} // updateBoard
		
		public void deleteBoardByNum(int num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "";
			
			try {
				con = JdbcUtils.getConnection();
				sql = "DELETE FROM board WHERE num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.close(con, pstmt);
			}
		} // deleteBoard()
		
		public boolean updateAndAddReply(BoardVo boardVo) {
			Connection con = null;
			PreparedStatement pstmt = null;			
			String sql = "";
			
			try {
				con = JdbcUtils.getConnection();
				con.setAutoCommit(false);	// ���� Ŀ���� �������� �ٲ۴�
				sql  = "UPDATE board ";
				sql += "SET re_seq = re_seq + 1 ";
				sql += "WHERE re_ref = ? ";
				sql += "AND re_seq > ? ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, boardVo.getReRef());
				pstmt.setInt(2, boardVo.getReSeq());
				pstmt.executeUpdate();
				// update������ ���� pstmt ��ü �ݱ�
				pstmt.close(); // ��Ȱ���� �ȵǼ� �ٽ� ���� �ؾߵ�
				
				sql = "INSERT INTO board (num, name, passwd, subject, content, readcount, reg_date, ip, file, re_ref, re_lev, re_seq) ";
				sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, boardVo.getNum());
				pstmt.setString(2, boardVo.getName());
				pstmt.setString(3, boardVo.getPasswd());
				pstmt.setString(4, boardVo.getSubject());
				pstmt.setString(5, boardVo.getContent());
				pstmt.setInt(6, boardVo.getReadcount());
				pstmt.setTimestamp(7, boardVo.getRegDate());
				pstmt.setString(8, boardVo.getIp());
				pstmt.setString(9, boardVo.getFile());
				pstmt.setInt(10, boardVo.getReRef());     // ���� �׷�
				pstmt.setInt(11, boardVo.getReLev() + 1); // ��۾��� ������ �鿩���� + 1
				pstmt.setInt(12, boardVo.getReSeq() + 1); // ��۾��� ������ �׷쳻 ���� + 1
				// insert�� ����
				pstmt.executeUpdate();				
				
				con.commit(); // ���⼭ ���� ����ų �� ����.
				
				con.setAutoCommit(true); // �⺻���� true�� ����
				
				return true; // �̷��� finally�� �����Ѵ�.
			} catch (Exception e) {
				e.printStackTrace();
				try {
					con.rollback(); // ���� �߻��� �������� ������.
				} catch (SQLException e1) {
					e1.printStackTrace();
				} // ���� �߻��� �������� ������.
				return false;
			} finally {
				JdbcUtils.close(con, pstmt);
			}
		} // updateAndAddReply()
	
	public static void main(String[] args) {
		BoardDao boardDao = BoardDao.getInstance();
		
		for(int i=0 ; i<100 ; i++) {
			BoardVo boardVo = new BoardVo();
			int num = boardDao.getNextNum();
			boardVo.setNum(num);
			boardVo.setName("ȫ�浿"+i);
			boardVo.setPasswd("1324");
			boardVo.setSubject("������"+i);
			boardVo.setContent("�۳���"+i);
			boardVo.setReadcount(0);
			boardVo.setRegDate(new Timestamp(System.currentTimeMillis()));
			boardVo.setIp("127.0.0.1");
			boardVo.setReRef(num);
			boardVo.setReLev(0);
			boardVo.setReSeq(0);
			
			System.out.println(boardVo);
			boardDao.addBoard(boardVo);
		}
	} // main()
}
