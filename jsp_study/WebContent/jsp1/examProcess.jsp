<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// request 기본객체
	// 사용자가 입력 파라미터값 가져오기, 인자로 name속성값 전달.
	
	// request 파라미터 정보는 모두 String형
	// request 파라미터 정보가 없으면 null을 리턴함
	String strNum = request.getParameter("num");

	// String -> 정수형
	int intNum = Integer.parseInt(strNum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("파라미터값-문자 : "+strNum);
	out.println("파라미터값-숫자 : "+intNum);
%>
	
</body>
</html>