<%@ page import="com.exam.dao.MemberDao"%>
<%@ page import="com.exam.vo.MemberVo"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//세션값 가져오기
String id = (String) session.getAttribute("id");
//세션값 없으면  loginForm.jsp 이동
if(id==null) {
	%>
	<script>
	alert('잘못된 경로 입니다.');
	location.href = 'loginForm.jsp' // sendRedirect을 쓰면 뒤로가기 해도 정보가 없기에 그냥 location으로 이동한다.
	</script>
	<%
	// response.sendRedirect("main.jsp"); // 가진 정보 전부 폐기처분
	return;
}
//DAO 객체 준비
MemberDao memberDao = new MemberDao();
//현재 로그인된 id 기준으로 회원정보 한개 가져오기
MemberVo memberInfo = memberDao.getMemberById(id);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 조회</h1>
	<hr>
	<%
	Timestamp timestamp = memberInfo.getRegDate();
	Date date = new Date(timestamp.getTime());
	%>
	아이디: <%=memberInfo.getId() %><br>
	패스워드: <%=memberInfo.getPasswd() %><br>
	이름: <%=memberInfo.getName() %><br>
	나이: <%=memberInfo.getAge() %><br>
	성별: <%=memberInfo.getGender() %><br>
	이메일: <%=(memberInfo.getEmail() == null)? " " : memberInfo.getEmail() %><br>
	가입날짜: <%=sdf.format(date) %><br>
	
	<h3><a href="main.jsp">메인화면</a></h3>
</body>
</html>