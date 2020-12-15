package com.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.mapper.MemberMapper;
import com.exam.vo.MemberVo;

public class MemberMyBatisDao {
	
	private static MemberMyBatisDao instance = new MemberMyBatisDao();
	
	private static MemberMyBatisDao getInstance() {
		return instance;
	}
	
	private SqlSessionFactory sqlSessionFactory;
	
	private MemberMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	public MemberVo getMemberById(String id) {
		MemberVo memberVo = null;
		
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			memberVo = mapper.getMemberById(id);
		}
		
//		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//		memberVo = mapper.getMemberById(id);
		
		return memberVo;
	}
	
	public List<MemberVo> getAllMembers() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			List<MemberVo> list = mapper.getAllMembers();
			return list;
		}
	}
	
	public static void main(String[] args) {
		MemberMyBatisDao dao = MemberMyBatisDao.getInstance();
		
		MemberVo memberVo = dao.getMemberById("kal");		
		System.out.println(memberVo);
		System.out.println("================================");
		List<MemberVo> list = dao.getAllMembers();
		for(MemberVo vo: list) {
			System.out.println(vo);
		}
 	}
}
