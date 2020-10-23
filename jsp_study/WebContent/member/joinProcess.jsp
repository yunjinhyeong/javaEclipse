<%@ page import="java.sql.Timestamp"%>
<%@ page import="com.exam.dao.MemberDao"%>
<%@ page import="com.exam.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//post 파라미터값 한글처리
request.setCharacterEncoding("utf-8");
// VO객체 준비
// MemberVo memberVo = new MemberVo();
%>
<!-- 액션태그 useBean으로 VO 객체 준비하기 useBean은 Vo기본생성자가 있어야 쓸수 있다. -->
<jsp:useBean id="memberVo" class="com.exam.vo.MemberVo"/>
<%
// 파라미터 찾기
// memberVo.setId(request.getParameter("id"));
// memberVo.setPasswd(request.getParameter("passwd"));
// memberVo.setName(request.getParameter("name"));
// memberVo.setAge(Integer.parseInt(request.getParameter("age")));
// memberVo.setGender(request.getParameter("gender"));
// memberVo.setEmail(request.getParameter("email"));
%>
<jsp:setProperty property="*" name="memberVo"/> <!-- 한방에 setter 호출 -->

<%
//회원가입(날짜시간) 정보 설정
memberVo.setRegDate(new Timestamp(System.currentTimeMillis()));

//DAO 객체 준비
// MemberDao memberDao = new MemberDao();
MemberDao memberDao = MemberDao.getInstance();

//회원가입 처리 수행
memberDao.addMember(memberVo);
%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>joinProcess</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<h1>회원가입 성공!</h1> -->
	<!-- html관련 다 지우고 <script>만 넣어 실행하면 alert실행 후 loginForm.jsp 로 이동 -->
<script>
	alert('회원가입 성공!');
	location.href = 'loginForm.jsp';
</script>

<!-- </html> -->