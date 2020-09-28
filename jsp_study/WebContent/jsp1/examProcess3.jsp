<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// post 요청 파라미터 한글처리 & 바이트 단위로 쪼개진걸 문제없게 만들어줌 & post는 용량제한이 없다
	request.setCharacterEncoding("utf-8");
	// 파라미터 name age 가져오기 변수에 저장
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String job = request.getParameter("job");
	// checkbox 파라미터 특이! value값이 여러개 -> 배열변수로 저장
	// checkbox 하나도 선택한 값이 없을때 null을 리턴함
	String[] hobbies = request.getParameterValues("hobby");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이름 :	<%=name %><br>
성별 :	<%=gender %><br>
직업 :	<%=job %><br>
취미 :
<%
	if(hobbies != null){
		for(String hobby:hobbies) {
				// out.println("직업 :"+hobby+" ");
				%>
				<%=hobby %>
				<%
		}
				
	}
%>
	
</body>
</html>