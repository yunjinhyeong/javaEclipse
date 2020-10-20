<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");
if(id==null){
	%>
	<script>
	alert('잘못된 경로 입니다.');
	location.href = 'loginForm.jsp'
	</script>
	<%
	return;
}
request.setCharacterEncoding("uft-8");
String passwd = request.getParameter("passwd");
MemberDao memberDao = MemberDao.getInstance();
int check = memberDao.userCheck(id, passwd);
if(check == 1) {
	response.sendRedirect("updateForm.jsp");
	return;
} else {
	%>
	<script>
		alert('패스워드 틀림');
		history.back();
	</script>
	<%
}
%>