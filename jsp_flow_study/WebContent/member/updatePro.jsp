<%@page import="com.exam.dao.MemberDao"%>
<%@page import="com.exam.vo.MemberVo"%>
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
request.setCharacterEncoding("utf-8");
MemberVo memberVo = new MemberVo();
memberVo.setId(request.getParameter("id"));
memberVo.setPasswd(request.getParameter("passwd"));
memberVo.setName(request.getParameter("name"));
memberVo.setAge(Integer.parseInt(request.getParameter("age")));
memberVo.setGender(request.getParameter("gender"));
memberVo.setEmail(request.getParameter("email"));
MemberDao memberDao = MemberDao.getInstance();
memberDao.update(memberVo);
%>
<script>
	alert('회원수정 완료');
	location.href='main.jsp';
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>