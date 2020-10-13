<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// post 파라미터값 한글처리
request.setCharacterEncoding("utf-8");

// 폼 파라미터값 가져오기 id passwd 가져오기
String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim();
String passwd = request.getParameter("passwd");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>