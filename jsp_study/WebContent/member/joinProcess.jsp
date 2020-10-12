<%@page import="java.sql.Timestamp"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//post 파라미터값 한글처리
request.setCharacterEncoding("utf-8");

//VO객체 준비
MemberVo memberVo = new MemberVo();

//파라미터 찾기
memberVo.setId(request.getParameter("id"));
memberVo.setPasswd(request.getParameter("passwd"));
memberVo.setName(request.getParameter("name"));
memberVo.setAge(Integer.parseInt(request.getParameter("age")));
memberVo.setGender(request.getParameter("gender"));
memberVo.setEmail(request.getParameter("email"));

//회원가입(날짜시간) 정보 설정
memberVo.setRegDate(new Timestamp(System.currentTimeMillis()));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinProcess</title>
</head>
<body>
	<h1>dfsa</h1>
</html>