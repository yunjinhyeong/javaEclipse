# member
#### joinForm
```
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="joinProcess.jsp" method="post">
		아이디: <input type="text" name="id"><br>
		패스워드: <input type="password" name="passwd"><br>
		이름: <input type="text" name="name"><br>
		나이: <input type="number" name="age" min="0" max="200"><br>
		성별: <input type="radio" name="gender" value="남"> 남성
		      <input type="radio" name="gender" value="여"> 여성<br>
		이메일: <input type="email" name="email"><br>
		<input type="submit" value="회원가입">      
	</form>
</body>
```
![joinForm](imgs/joinForm.png)
#### joinForm정보를 joinProjess로 받아들이기
- 맨 윗부분에 <%@page import="com.exam.vo.MemberVo"%> import먼저해준다.
- RegDate를 사용하기 위해 이어서 <%@page import="java.sql.Timestamp"%>도 import해준다.
```
<%
//post 파라미터값 한글처리
request.setCharacterEncoding("utf-8");

//VO객체 준비
MemberVo memberVo = new MemberVo();

//파라미터 찾기
memberVo.setId(request.getParameter("id"));
memberVo.setPasswd(request.getParameter("passwd"));
memberVo.setName(request.getParameter("name"));
memberVo.setAge(Integer.parseInt(request.getParameter("age")));
memberVo.setGender(request.getParameter("gender"));
memberVo.setEmail(request.getParameter("email"));

//회원가입(날짜시간) 정보 설정
memberVo.setRegDate(new Timestamp(System.currentTimeMillis()));
%>
```