<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//DAO객체 준비
MemberDao memberDao = MemberDao.getInstance();
//전체 회원정보 가져오기
List<MemberVo> memberList = memberDao.getAllMembers();
// simple-json 라이브러리 사용해서
// membList 자바 객체를 JSONArray(list같은것), JSONObject(해쉬맵같은것) 객체로 변환
// 전체 내용을 담을 JSONArray 준비
JSONArray jsonArray = new JSONArray();

for(MemberVo memberVo : memberList){
	JSONObject jsonObject = new JSONObject(); // 일종의 map 컬렉션
	// memberVo 내용을 jsonObject에 복사하기
	jsonObject.put("id", memberVo.getId());
	jsonObject.put("name", memberVo.getName());
	jsonObject.put("age", memberVo.getAge());
	// jsonObject를 jsonArray에 추가하기
	jsonArray.add(jsonObject);
} // for
// 웹서버 콘솔에 출력
System.out.println(jsonArray);
// 웹 브라우저에 출력
// out.println(jsonArray);
%>
<%-- 웹 브라우저에 출력 --%>
<%=jsonArray%>
