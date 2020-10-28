<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// POST 전송 파라미터값 한글처리
request.setCharacterEncoding("utf-8");
// 파라미터 id가져오기
String id = request.getParameter("id");
// DAO 준비
MemberDao memberDao = MemberDao.getInstance();
// id와 일치하는 행의 갯수 가져오기
int count = memberDao.getCountById(id);
// JSONObject 객체 준비
JSONObject jsonObject = new JSONObject();
jsonObject.put("count", count);

%>
<%-- 웹브라우저로 jsonObject 문자열 표현을 출력 --%>
<%=jsonObject.toString() %>