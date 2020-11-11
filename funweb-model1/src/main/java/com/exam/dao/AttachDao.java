package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.exam.vo.AttachVo;

public class AttachDao {
	
	private static AttachDao instance = new AttachDao();
	
	public static AttachDao getInstance() { return instance; }
	
	private AttachDao() {
		
	}
	
	public void insertAttach(AttachVo attachVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = JdbcUtils.getConnection();
			
			sql = "insert into attach (filename, uploadpath, image, no_num) ";
			sql += "value (?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, attachVo.getFilename());
			pstmt.setString(2, attachVo.getUploadpath());
			pstmt.setString(3, attachVo.getImage());
			pstmt.setInt(4, attachVo.getNoNum());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	}
}
