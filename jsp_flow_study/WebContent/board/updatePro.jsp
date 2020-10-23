<%@page import="com.exam.dao.BoardDao"%>
<%@page import="com.exam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
// BoardVo boardVo = new BoardVo();
// 파라미터값 pageNum 가져오기
String pageNum = request.getParameter("pageNum");
%>
<!-- jsp액션태그 -->
<jsp:useBean id="boardVo" class="com.exam.vo.BoardVo"/>
<%
// String pageNum = request.getParameter("pageNum");
// boardVo.setNum(Integer.parseInt(request.getParameter("num")));
// boardVo.setName(request.getParameter("name"));
// boardVo.setPasswd(request.getParameter("passwd"));
// boardVo.setSubject(request.getParameter("subject"));
// boardVo.setContent(request.getParameter("content"));
%>
<jsp:setProperty property="*" name="boardVo"/>
<%
BoardDao boardDao = BoardDao.getInstance();
boolean isPasswdOk = boardDao.isPasswdOk(boardVo.getNum(), boardVo.getPasswd());
if(isPasswdOk) {
	boardDao.updateBoard(boardVo);
	response.sendRedirect("content.jsp?num="+boardVo.getNum()+"&pageNum="+pageNum);
} else {
	%>
	<script>
		alert('글 비밀번호 틀림');
		history.back();
	</script>
	<%
}
%>