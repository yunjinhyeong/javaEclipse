<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- head 컨텐츠 영역 --%>
<jsp:include page="/include/headContent.jsp"/>
<link href="/css/subpage.css" rel="stylesheet" type="text/css"  media="all">
</head>

<body>
<div id="wrap">
	<%-- header 영역 --%>
	<jsp:include page="/include/topHeader.jsp"/><!-- jsp액션태그 사용해서 헤더부분을 구성하고 있는 파일을 불러옴 (상대경로) 수정의 용이성 10페이지분량을 수정하려고 할때 이거 하나만 바꿔주면 다 해결됨-->
  
	<div class="clear"></div>
	<div id="sub_img"></div>
  
	<div class="clear"></div>
	<!-- submenuCompany로이동 -->
<!-- 	<nav id="sub_menu">  
        <ul>
            <li> <a href="welcome.html">Welcome</a></li>
            <li> <a href="history.html">History</a></li>
            <li> <a href="#">Newsroom</a></li>
            <li> <a href="#">Public Policy</a></li>
    	</ul>   
    </nav> -->
    <!-- 원래 nav영역 -->
    <jsp:include page="/include/submenuCompany.jsp"/>
	
	<article>
		<h1>Welcome</h1>
		<figure class="ceo"><img src="/images/company/CEO.jpg" width="196" height="226" alt="CEO">
		<figcaption>Fun Web CEO Michael</figcaption></figure>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam bibendum, libero faucibus porttitor bibendum, lorem purus sollicitudin lacus, ut laoreet sem dui non nibh. Fusce tempor, eros vulputate luctus malesuada, nunc nisi rutrum massa, vestibulum rhoncus metus tellus in eros. Ut vehicula luctus cursus. Aliquam nunc neque, condimentum eu fringilla quis, feugiat in erat. Aliquam vel neque dolor, eu porttitor nulla. Cras ac dui metus, non viverra ligula. Maecenas sed tortor justo. Duis vehicula nisl sed sapien egestas ut aliquet purus mattis. Vestibulum vitae libero sapien, sed ultricies lacus. Morbi sapien metus, ullamcorper rhoncus cursus in, facilisis id felis. Aliquam id elit lacus, at laoreet enim. Nullam quis purus dui, eu molestie augue.</p>
		<p>Nam venenatis neque quis tortor laoreet egestas hendrerit id diam. Nam adipiscing urna non tortor ornare vel consectetur est cursus. Morbi sed libero quam, sed scelerisque ligula. Vivamus vitae massa in quam hendrerit porttitor. Vivamus ac feugiat odio. In hac habitasse platea dictumst. Proin porta tempus ligula ut eleifend. Maecenas tincidunt elementum purus, nec venenatis nisl sodales vel. Mauris at neque nisi, nec tincidunt nulla. Mauris porta, nunc et semper lobortis, sem erat tempus massa, at porttitor dolor mi non sem.</p>
		<p>Phasellus lectus elit, sagittis quis aliquet vulputate, consectetur ac velit. Mauris molestie, quam et ultrices fringilla, lectus magna auctor nisl, a congue tortor nisi eu magna. Phasellus eleifend tristique sapien sed eleifend. Nunc nunc sem, interdum ac mattis in, mollis ut felis. Aenean varius, ligula id consequat condimentum, diam mauris ullamcorper arcu, ut porttitor libero neque sit amet velit. Ut gravida ultricies est, non mollis massa pharetra imperdiet. Duis commodo libero eget massa tempor eget lacinia mi elementum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque at leo et massa euismod bibendum. Mauris consectetur dictum orci pretium hendrerit. Integer ipsum ligula, fringilla nec iaculis nec, ultrices eu diam. Nunc tellus nulla, fringilla eu tempor ac, commodo at augue. Vestibulum vel congue tellus.</p>
	</article>
    
	<div class="clear"></div>
	<!-- bottomFooter로 이동 -->
<!-- 	<footer>   -->
<!-- 		<hr> -->
<!-- 		<div id="copy"> -->
<!-- 			All contents Copyright 2011 FunWeb Inc. all rights reserved<br> -->
<!-- 			Contact mail : funweb@funwebbiz.com Tel: +82 64 123 4315 Fax +82 64 123 4321 -->
<!-- 		</div> -->
<!-- 		<div id="social"> -->
<!-- 			<img src="../images/facebook.gif" width="33" height="33" alt="Facebook"> <img src="../images/twitter.gif" width="33" height="34" alt="Twitter"> -->
<!-- 		</div> -->
<!-- 	</footer> -->
	<jsp:include page="/include/bottomFooter.jsp"/>
</div>

</body>
</html>   

    