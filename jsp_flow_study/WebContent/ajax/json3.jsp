<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDao memberDao = MemberDao.getInstance();
List<MemberVo> memberList = memberDao.getAllMembers();
JSONArray jsonArray = new JSONArray();
for(MemberVo memberVo : memberList) {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("id", memberVo.getId());
	jsonObject.put("name", memberVo.getName());
	jsonObject.put("age", memberVo.getAge());
	jsonArray.add(jsonObject);
}
%>
<%=jsonArray%>