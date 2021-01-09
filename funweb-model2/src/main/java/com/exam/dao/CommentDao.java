package com.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.mapper.CommentMapper;
import com.exam.vo.CommentVo;
import com.exam.vo.Criteria;

import lombok.extern.java.Log;

@Log
public class CommentDao {
	
	private static CommentDao instance = new CommentDao();
	
	public static CommentDao getInstance() {
		return instance;
	}

	private SqlSessionFactory sqlSessionFactory;
	
	private CommentDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	
	public int getTotalCountByNno(int nno) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			int count = commentMapper.getTotalCountByNno(nno);
			return count;
		}
	}
	
	public int addComment(CommentVo commentVo) {
//		System.out.println(commentVo);
		log.info(commentVo.toString());
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			int count = commentMapper.insert(commentVo);
			return count;
		}
	}
	
	public CommentVo getCommentByCno(int cno) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			CommentVo commentVo = commentMapper.getCommentByCno(cno);
			return commentVo;
		}
	}
	
	public int deleteByCno(int cno) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			int count = commentMapper.deleteByCno(cno);
			return count;
		}
	}
	
	public void update(CommentVo commentVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			commentMapper.update(commentVo);
		}
	}
	
	public List<CommentVo> getComments(int nno) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			List<CommentVo> list = commentMapper.getComments(nno);
			return list;
		}
	}
	
	
	public List<CommentVo> getCommentsWithPaging(int nno, Criteria cri) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			List<CommentVo> list = commentMapper.getCommentsWithPaging(nno, cri);
			return list;
		}
	}
	
	
	// ���� ���� �޼ҵ� (Ʈ����� ó�� - ����Ŀ��)
	public void addReplyComment(CommentVo commentVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(false)) { // ����Ŀ��
			CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
			
			// ���� �۱׷� ������ �������� ������Ʈ�ϱ�
			commentMapper.updateReSeq(commentVo.getReRef(), commentVo.getReSeq());
			
			// ����� ��� ������ VO�� re �� �����ϱ�
			commentVo.setReLev(commentVo.getReLev() + 1);
			commentVo.setReSeq(commentVo.getReSeq() + 1);
			
			// ��� insert�ϱ�
			commentMapper.insert(commentVo);

			// Ŀ���ϱ�
			sqlSession.commit();
		}
	}
	
}




