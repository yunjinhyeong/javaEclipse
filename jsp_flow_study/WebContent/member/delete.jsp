<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");
if(id==null){
	response.sendRedirect("loginForm.jsp");
	return;
}
request.setCharacterEncoding("utf-8");
String passwd = request.getParameter("passwd");
MemberDao memberDao = MemberDao.getInstance();
int check = memberDao.userCheck(id, passwd);
if(check == 0) {
	%>
	<script>
		alert('패스워드 틀림');
		history.back();
	</script>
	<%
	return;
}
if(check == 1) {
}
memberDao.deleteById(id);
%>
<script>
	alert('회원탈퇴 완료');
	location.href = 'loginForm.jsp';
</script>