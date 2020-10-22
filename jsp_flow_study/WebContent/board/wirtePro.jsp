<%@page import="java.sql.Timestamp"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@page import="com.exam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
BoardVo boardVo = new BoardVo();
boardVo.setName(request.getParameter("name"));
boardVo.setPasswd(request.getParameter("passwd"));
boardVo.setSubject(request.getParameter("subject"));
boardVo.setContent(request.getParameter("content"));
BoardDao boardDao = BoardDao.getInstance();
int nextNum = boardDao.getNextNum();
boardVo.setNum(nextNum);
boardVo.setIp(request.getRemoteAddr());
boardVo.setRegDate(new Timestamp(System.currentTimeMillis()));
boardVo.setReadcount(0); // 처음 글 만드는데 당연히 조회수 0
boardVo.setReRef(nextNum); // 주글일때 num이랑 re_ref랑 같아야지
boardVo.setReLev(0); // 주글인데 들여쓰기 레벨이 필요없지
boardVo.setReSeq(0); // 주글인데 당연히 그 그룹내 우선순위 0번째
boardDao.addBoard(boardVo); // insert해줘야지
response.sendRedirect("content.jsp?num="+boardVo.getNum()); // 글의 상세보기니 num이 기준인건 당연
%>