<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%-- head 컨텐트 영역 --%>
<jsp:include page="/WEB-INF/views/include/headContent.jsp" />

<link href="/css/subpage.css" rel="stylesheet" type="text/css"  media="all">
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
<link href="/css/custom2.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<%-- header 영역 --%>
	<jsp:include page="/WEB-INF/views/include/topHeader.jsp" />

	<div class="clear"></div>
	<div id="sub_img_center"></div>

	<div class="clear"></div>
	<%-- nav 영역 --%>
	<jsp:include page="/WEB-INF/views/include/submenuBoard.jsp" />

	<article>

	<h1>자료실 게시판 상세보기</h1>

	<table id="notice">
		<tr>
			<th scope="col" class="tno">글번호</th>
			<td class="left" width="500">${ noticeVo.num }</td>
		</tr>
		<tr>
			<th scope="col" class="tread">조회수</th>
			<td class="left">${ noticeVo.readcount }</td>
		</tr>
		<tr>
			<th scope="col" class="twrite">작성자</th>
			<td class="left">${ noticeVo.id }</td>
		</tr>
		<tr>
			<th scope="col" class="tdate">작성일자</th>
			<td class="left"><fmt:formatDate value="${ noticeVo.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">글제목</th>
			<td class="left">${ noticeVo.subject }</td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">글내용</th>
			<td class="left">${ noticeVo.content }</td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">첨부파일</th>
			<td class="left">

			<c:if test="${ not empty attachList }">

				<c:forEach var="attach" items="${ attachList }">

					<c:choose>
					<c:when test="${ attach.image eq 'I' }">
						<p>
							<a href="/upload/${ attach.uploadpath }/${ attach.filename }">
								<img src="/upload/${ attach.uploadpath }/${ attach.filename }" width="100" height="100">
							</a>
						</p>
					</c:when>
					<c:otherwise>
						<p>
							<a href="/upload/${ attach.uploadpath }/${ attach.filename }">
								${ attach.filename }
							</a>
						</p>
					</c:otherwise>
					</c:choose>

				</c:forEach>
			</c:if>

			</td>
		</tr>
	</table>

	<div id="table_search">

		<c:if test="${ not empty id }">
			<%-- 로그인 했을때 --%>
			<c:if test="${ id eq noticeVo.id }">
				<%-- 로그인 아이디와 글작성자 아이디가 같을때 --%>
				<input type="button" value="글수정" class="btn">
				<input type="button" value="글삭제" class="btn" onclick="remove()">
			</c:if>
			<input type="button" value="답글쓰기" class="btn">
		</c:if>

		<input type="button" value="목록보기" class="btn" onclick="location.href = 'fileNotice.do?pageNum=${ pageNum }'">
	</div>

	<div class="clear"></div>
	<div id="page_control">
	</div>
	<!-- 댓글영역 -->
	<div id="app" class="panel panel-default">
		<div class="panel-heading">
		<span class="glyphicon glyphicon-comment">댓글</span> <span class="glyphicon glyphicon-refresh"></span>
		</div>
		<div class="panel-body">
			<!-- 댓글리스트영역  -->
			<ul class="media-list">
    		   <li class="media" style="margin-left: 0px;" v-for="comment in commentList" v-bind:key="comment.cno">
    		   
    		   		<span class="pull-left" v-show="comment.reLev > 0">└</span>
          			<a class="pull-left" href="#">
            			<img alt="Generic placeholder image" src="/images/center/pic.jpg">
          			</a>
       				<div class="media-body">
            			<div class="media-heading">
            				<strong class="text-primary">{{comment.id}}</strong>
            				<small class="pull-right text-muted">{{comment.updateDate}}</small>
            			</div>
            			<p>{{comment.content}}</p>
        		</li>


      		</ul>
		</div>

		<div class="panel-footer">
			<textarea  rows="5" v-model="inputComment" class="form-control" placeholder="댓글을 입력하세요."></textarea>
			<br>
			<input type="button" v-on:click="addComment" class="btn btn-primary" value="등록 ">
			<small class="text-muted" style="margin-left : 10px"> {{remain}} / 600</small>

		</div>
		<div id="page_control"></div>
	</div>


	</article>

	<div class="clear"></div>
	<%-- footer 영역 --%>
	<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp" />
</div>

	<script src="/script/jquery-3.5.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
	<script>
	//게시글 삭제함수
		function remove() {
			let isDelete = confirm('${ noticeVo.num }번 글을 정말 삭제하시겠습니까?');
			if (isDelete) {
				location.href = 'fileDelete.jsp?num=${ noticeVo.num }&pageNum=${ pageNum }';
			}
		}
	</script>
	<script>
		new Vue({
			el: '#app',
			data: {
				commentList: [],
				inputComment : ''
			},
			computed: {
				//댓글입력 남은 글자수
				remain: function () {
					return 600 - this.inputComment.length;
				}
			},
			watch: {
				inputComment: function () {
					if(this.inputComment.length > 600){
						this.inputComment = this.inputComment.substring(0, 600)
					}

				}
			},
			methods: {
				// 댓글목록 가져오기
				getList: function() {
					let nno = ${ noticeVo.num }; //jsp의 el언어로 게시판 글번호를 출력해서 자바 스크립트 변수에 저장
					let vm = this; // ViewModel의 약칭, Vue객체 자기자신을 vm 변수로 저장

					$.ajax({
						url : 'http://localhost/comment' ,
						data: 'category=list&nno=' + nno,
						method: 'GET',
						success: function (response) {//response가 들어가는 이유?
							console.log(typeof response);
							console.log(response);

							if(response.isSuccess){
								vm.commentList = response.commentList;
							}
						},
						error: function(){
							alert('댓글 리스트 가져오기 오류 발생...')
						}
					});
				},//getList

				addComment: function() {


				} //addComment


			},
			mounted: function () {
				this.getList();
			}
		});

	</script>
</body>
</html>



