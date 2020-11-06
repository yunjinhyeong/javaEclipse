<%@page import="com.exam.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
String pageNum = request.getParameter("pageNum");
int num = Integer.parseInt(request.getParameter("num"));
String passwd = request.getParameter("passwd");
NoticeDao boardDao = NoticeDao.getInstance();
boolean isPasswdOk = boardDao.isPasswdOk(num, passwd);
if(isPasswdOk) {
	boardDao.deleteBoardByNum(num);
	response.sendRedirect("list.jsp?pageNum="+pageNum);
} else {
%>
	<script>
		alert('글 패스워드 틀림');
		history.back();
	</script>
	<%
}
%>