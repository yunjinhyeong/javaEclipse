<%@page import="com.google.gson.Gson"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDao memberDao = MemberDao.getInstance();
List<MemberVo> memberList = memberDao.getAllMembers();
Gson gson = new Gson();
String strJson = gson.toJson(memberList);
System.out.println(strJson);
%>
<%=strJson%>