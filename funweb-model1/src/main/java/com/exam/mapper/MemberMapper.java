package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.exam.vo.MemberVo;

// ���̹�Ƽ������ Mapper �������̽��� ������ ������ ��
public interface MemberMapper {

	@Select("SELECT * FROM member WHERE id = #{id}")
	MemberVo getMemberById(String id);
	
	@Select("SELECT * FROM member ORDER BY id")
	List<MemberVo> getAllMembers();
		
}