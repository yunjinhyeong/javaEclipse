<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// post 요청 파라미터 한글처리 & 바이트 단위로 쪼개진걸 문제없게 만들어줌 & post는 용량제한이 없다
	request.setCharacterEncoding("utf-8");

	// 파라미터 name age 가져오기 변수에 저장
	String strName = request.getParameter("name");
	
	int intAge = Integer.parseInt(request.getParameter("age"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이름 :	홍길동<br>
나이 :	22<br>
<%
	out.println("이름 : "+strName);
	out.println("나이 : "+intAge);
%>
<br>
<hr>
<%
	// 나이가 20살 이상이면 "..님의 나이는 20살 이상입니다."
	//					미만이면 "..님은 미성년자 입니다."
	if(intAge >= 20) {
		out.println(strName+"님의 나이는 ");
		out.println("20살 이상입니다.");
	} else if(intAge<20) {
		out.println(strName+"님은 미성년자 입니다.");
	}
%>
	
</body>
</html>