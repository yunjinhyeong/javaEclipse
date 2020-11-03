<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
MemberDao memberDao = MemberDao.getInstance();
int count = memberDao.getCountById(id);

JSONObject jsonObject = new JSONObject();
jsonObject.put("count", count);

%>
<%=jsonObject.toString()%>