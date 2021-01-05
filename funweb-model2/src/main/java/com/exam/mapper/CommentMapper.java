package com.exam.mapper;

import org.apache.ibatis.annotations.Insert;

import com.exam.vo.CommentVo;

public interface CommentMapper {
	
	@Insert("INSERT INTO comment (nno, id, content, reg_date, update_date) "
			+ "VALUES (#{nno}, #{id}, #{content}, #{regDate}, #{updateDate})")
	int insert(CommentVo commentVo);
}
