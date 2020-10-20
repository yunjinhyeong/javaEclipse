<%@page import="com.exam.dao.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
MemberVo memberVo = new MemberVo();
memberVo.setId(request.getParameter("id"));
memberVo.setPasswd(request.getParameter("passwd"));
memberVo.setName(request.getParameter("name"));
memberVo.setAge(Integer.parseInt(request.getParameter("age")));
memberVo.setGender(request.getParameter("gender"));
memberVo.setEmail(request.getParameter("email"));
memberVo.setRegDate(new Timestamp(System.currentTimeMillis()));
MemberDao memberDao = MemberDao.getInstance();
memberDao.addMember(memberVo);
%>
<script>
	alert('회원가입 성공!');
	location.href = 'loginForm.jsp';
</script>