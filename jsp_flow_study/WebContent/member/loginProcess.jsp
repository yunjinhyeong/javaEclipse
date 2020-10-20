<%@page import="com.exam.dao.MemberDao"%>
<%@page import="org.apache.catalina.filters.SetCharacterEncodingFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
MemberDao memberDao = MemberDao.getInstance();
int check = memberDao.userCheck(id, passwd);
if(check == 1){
	session.setAttribute("id", id); // 이게 있어야 세션으로 로그인 후 접근 가능한 페이지설정가능
	%>
	<script>
		alert('로그인 성공');
		location.href = 'main.jsp';
	</script>
	<%
} else if(check == 0) {
	%>
	<script>
		alert('패스워드 틀림');
		history.back();
	</script>
	<%
} else {
	%>
	<script>
		alert('아이디 없음');
		history.back();
	</script>
	<%
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProcess</title>
</head>
<body>

</body>
</html>