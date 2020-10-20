<%@page import="com.exam.vo.MemberVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");
if(id==null){
	%>
	<script>
		alert('잘못된 경로 입니다.');
		location.href = 'loginForm.jsp';
	</script>
	<%
	return;
}
MemberDao memberDao = MemberDao.getInstance();
MemberVo memberInfo = memberDao.getMemberById(id);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info</title>
</head>
<body>
	<h1>회원정보 조회</h1>
	<hr>
	아이디: <%=memberInfo.getId() %><br>
	패스워드: <%=memberInfo.getPasswd() %><br>
	이름: <%=memberInfo.getName() %><br>
	나이: <%=memberInfo.getAge() %><br>
	성별: <%=memberInfo.getGender() %><br>
	이메일: <%=memberInfo.getEmail() %><br>
	가입날짜: <%=sdf.format(memberInfo.getRegDate()) %><br>
	<h3><a href="main.jsp">메인화면</a></h3>
</body>
</html>