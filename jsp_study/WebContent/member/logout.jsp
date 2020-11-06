<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 세션 비우기 (초기화)
// session.removeAttribute("id"); // id세션만 지우는 코드
session.invalidate(); // 모든 세션 지우기
%>
<script>
	alert('로그아웃 되었습니다.');
	location.href = 'loginForm.jsp';
</script>