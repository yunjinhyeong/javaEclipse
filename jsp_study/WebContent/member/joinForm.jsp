<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디 - 회원가입</title>
<style>
span.positive{
	color: green;	
	font-style: italic;
}
span.negative{
	color: red;	
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="joinProcess.jsp" method="post">
		아이디: <input type="text" name="id">
					<span id="msgIdDup"></span>
		<br>
		패스워드: <input type="password" name="passwd"><br>
		이름: <input type="text" name="name"><br>
		나이: <input type="number" name="age" min="0" max="200"><br>
		성별: <input type="radio" name="gender" value="남"> 남성
		      <input type="radio" name="gender" value="여"> 여성<br>
		이메일: <input type="email" name="email"><br>
		<input type="submit" value="회원가입">
	</form>
<script src="../js/jquery-3.5.1.js"></script>
<script>
	function process(item) {
// 		let spanMsg = document.getElementById('msgIdDup');
		let $spanMsg = $('#msgIdDup'); // 변수앞에 $있으면 jquery를 갖춘객체라는 현장용어
		if(item.count == 0) { // 아이디 사용가능
// 			$spanMsg.html('사용가능한 아이디 입니다.').css('color','red');
			$spanMsg.html('사용가능한 아이디 입니다.').addClass('positive').removeClass('negative');
		} else { // item.count == 1 // 아이디 중복됨
// 			$spanMsg.html('이미 사용중인 아이디 입니다.').css('color','green');
			$spanMsg.html('이미 사용중인 아이디 입니다.').addClass('negative').removeClass('positive');
		}
	} // process
	// 키 이벤트 연결
	// 키보드 버튼이 눌렀다 떼어졌을때
	$('input[name="id"]').keyup(function () {
// 		let id = $(this).val().trim();
		let str = $(this).serialize();
		$.ajax({
			url: 'ajaxIdDupCheck.jsp',
			data: str, // 'id=' + id,
			success: function(data) { // 위의 data가 아님
					process(data);
				}
		});
	});
</script>
</body>
</html>