<%@page import="java.sql.Timestamp"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@page import="com.exam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String pageNum = request.getParameter("pageNum");
// BoardVo boardVo = new BoardVo();
%>
<jsp:useBean id="boardVo" class="com.exam.vo.BoardVo"/>
<%
// boardVo.setName(request.getParameter("name"));
// boardVo.setPasswd(request.getParameter("passwd"));
// boardVo.setSubject(request.getParameter("subject"));
// boardVo.setContent(request.getParameter("content"));
// boardVo.setReRef(Integer.parseInt(request.getParameter("reRef")));
// boardVo.setReLev(Integer.parseInt(request.getParameter("reLev")));
// boardVo.setReSeq(Integer.parseInt(request.getParameter("reSeq")));
%>
<jsp:setProperty property="*" name="boardVo"/>
<%
BoardDao boardDao = BoardDao.getInstance();
int nextNum = boardDao.getNextNum();
boardVo.setNum(nextNum);
boardVo.setIp(request.getRemoteAddr());
boardVo.setRegDate(new Timestamp(System.currentTimeMillis()));
boardVo.setReadcount(0);
boardDao.updateAndAddReply(boardVo);
response.sendRedirect("content.jsp?num="+boardVo.getNum()+"&pageNum="+pageNum);
%>