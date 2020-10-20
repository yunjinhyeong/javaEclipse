<%@page import="com.exam.vo.MemberVo"%>
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
MemberDao memberDao = MemberDao.getInstance();
MemberVo memberVo = memberDao.getMemberById(id);
String gender = memberVo.getGender();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<hr>
	<form action="updatePro.jsp" method="post">
		아이디: <input type="text" name="id" value="<%=memberVo.getId()%>" readonly><br>
		패스워드: <input type="password" name="passwd" value="<%=memberVo.getPasswd()%>" ><br>
		이름: <input type="text" name="name" value="<%=memberVo.getName()%>" ><br>
		나이: <input type="number" name="age" value="<%=memberVo.getAge()%>" ><br>
		성별: <input type="radio" name="gender" value="남" <%=(gender.equals("남"))?"checked":""%>>남성
				 <input type="radio" name="gender" value="여" <%=(gender.equals("여"))?"checked":""%>>여성<br>
		이메일: <input type="email" name="email" value="<%=memberVo.getEmail()==null ? "" : memberVo.getEmail()%>"><br>
		<input type="submit" value="회원수정">	
	</form>
</body>
</html>