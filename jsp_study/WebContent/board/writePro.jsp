<%@page import="com.exam.dao.BoardDao"%>
<%@page import="com.exam.vo.BoardVo"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// post 파라미터값 한글처리
request.setCharacterEncoding("utf-8");
// BoardVo 객체준비
BoardVo boardVo = new BoardVo();
// 파라미터값 가져와 VO 에 저장
boardVo.setName(request.getParameter("name")); // 이 jsp를 부른 wirteForm에서 "name"값 가져와 vo를 활용해 setName시킨다.
boardVo.setPasswd(request.getParameter("passwd"));
boardVo.setSubject(request.getParameter("subject"));
boardVo.setContent(request.getParameter("content"));
// insert를 위해 Dao객체준비
BoardDao boardDao = BoardDao.getInstance();
// 글번호 가져오기
int nextNum = boardDao.getNextNum();
boardVo.setNum(nextNum);
// ip regDate readcount 값 저장
boardVo.setIp(request.getRemoteAddr());
boardVo.setRegDate(new Timestamp(System.currentTimeMillis()));
boardVo.setReadcount(0); // 조회수
// re_ref, re_lev, re_seq
boardVo.setReRef(nextNum); // 그룹번호, 주글번호는 그룹번혹가 됨
boardVo.setReLev(0); // 주글은 들여쓰기 0
boardVo.setReSeq(0); // 주글일때는 글그룹 내에서 순번이 0(첫번째)
// 주글 등록하기
boardDao.addBoard(boardVo);
// 글내용 상세보기 화면 content.jsp로 이동
response.sendRedirect("content.jsp?num="+boardVo.getNum());
%>