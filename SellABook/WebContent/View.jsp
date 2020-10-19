<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>


<link rel="stylesheet" href="css/View3.css" type="text/css">
<link rel="stylesheet" href="css/topBanner3.css" type="text/css">
</head>
<body>
	<div id="logo">
		<a href="MainController"><img src="Image/로고판다.png" alt="로고" id="logoImg"></a>
	</div>
	<div id="bodydiv">
		<div id="topDiv">
			<div id="searchDiv">
				<form action="SearchController" method="GET" name="searchForm"
					class="form">
					<select name="searchCondition">
						<option selected disable hidden>검색조건</option>
						<option value="BCATEGORY">카테고리</option>
						<option value="BPUBLISHER">출판사</option>
						<option value="BTITLE">제목</option>
						<option value="BCONTENT">내용</option>
						<option value="BWRITER">작가</option>
					</select> <input type="text" placeholder="내용" name="search" />
					<button onclick="search()">검색</button>
				</form>
			</div>

			<div id="loginDiv">
				<c:choose>

					<c:when test="${sessionScope.member.id == null}">
						
						<div id="form3">
				<button onclick="join()" id="joinbtn">회원가입</button>
				<button onclick="login()" id="loginbtn">로그인</button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="form2">
				<p>
					환영합니다 ${sessionScope.member.name}님
				
				<button onclick="logout()" id="logoutbtn">로그아웃</button>
				</p>
				</div>
					</c:otherwise>

				</c:choose>
			</div>
		</div>
		<div id="bodyDiv">
		<div>
			<div class="image">
				<img alt="${book.image }" src="Image/${book.image }">
			</div>
			<div class="two">
				<div id="infoDiv">
					<table>
						<tr>
							<td rowspan="4"><img src="Image/${book.cover}"
								alt="${book.title}" width="180px" height="330px%" /></td>
							<th class="titleTH">제목</th>
							<td class="title">${book.title}</td>
							<th class="titleTH">가격</th>
							<td class="titleTD">${book.price}원</td>
						</tr>
						<tr>
							<th class="titleTH">작가</th>
							<td class="title">${book.writer}</td>
							<th class="titleTH">출판사</th>
							<td class="titleTD">${book.publisher}</td>
						</tr>
						<tr>
							<th class="titleTH">장르</th>
							<td class="title">${book.genre}</td>
							<th class="titleTH">카테고리</th>
							<td class="titleTD">${book.category}</td>
						</tr>
						<tr>
							<th class="titleTH">한줄 평</th>
							<td colspan="2" class="title" width="350px">${book.comment}</td>
							<td><button type="button"
										onclick="window.open('${book.site }') " id="buyIcon"><img src="Image/구매.png" alt="구매하기"/></button></td>
						</tr>
					</table>
				</div>
				<div class="both">
					<div class="left">
					</div>
					<!-- 표지값 -->

					<div class="right">
					</div>
				</div>
			</div>
			<div class="three">


				<h3 class="hidden">줄거리</h3>
				<article class="content_wrap" id="synopsis">
					<div id="SynopsisDiv" class="SynopsisText">${book.content }</div>
					<a href="javascript:showplay();" class="btn_more" id="synopMore">더보기</a>
					<input name="hidTempSynopsis" type="hidden" id="hidTempSynopsis"
						value="0">
				</article>
</div>
<h3>동영상</h3>

<div id="videoDiv">
	
				<c:choose>
					<c:when test="${book.video  eq null}">
					<div id="noVideoImg">
						<img src="Image/noVideo.jpg" alt="동영상이 지원되지 않습니다."/>
						</div>
					</c:when>
					<c:otherwise>

						<p align="center">
							<iframe src=${book.video }
								frameborder="100"
								allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen id="video"></iframe>
						</p>
					</c:otherwise>
				</c:choose>
			</div>
<hr/>

		</div>

		
			<h3>Review</h3>
			<div class="four">
			<div class="container">
				<form method="post" action="CommentController">
					<table style="text-align: center; border: 1px solid #dddddd">
						<tr>
							<td style="border-bottom: none;" valign="middle">리뷰</td>
							<input type="hidden" value="${sessionScope.member.id }" name="id"/>
							<td id="second"><input type="text"class="form-control" placeholder="상대방을 존중하는 댓글을 남깁시다."
								name="commentText">
								</td>
							<input type="hidden" name="bookNum" value="${book.num}" />
							<input type="hidden" name="page" value="${page}" />
							<td><input id="commentbtn"type="submit" value="댓글 작성"></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="reviewList">
			<c:forEach var="reviewList" items="${review }">
			 
				<table>
					<tr>
						<td class="reviewWriter" width="100px" style="padding:3px;">${reviewList.writer }</td>
						<td class="reviewContent" width="280px" style="text-align:left; padding:3px">${reviewList.content }</td>
						<td class="reviewDate" width="140px" style="padding:3px;">${reviewList.date }</td>
					</tr>
				</table>

			</c:forEach>
		</div>	
		</div>
	</div>
	</div>

</body>
<script>
	//더보기 토글
	function showplay() {
		var flag = $('#hidTempSynopsis');
		var SynopsisDiv = $('#SynopsisDiv');
		var flagValue = flag.val();
		if (flag != null) {
			if (flagValue == "0") {
				/*SynopsisDiv.css("height", "auto");*/
				SynopsisDiv.css("font-size", "12px");
				SynopsisDiv.css("display", "block");
				$("#synopMore").text("닫기");
				flag.val("1");
			} else {
				//SynopsisDiv.css("height", "77px");
				SynopsisDiv.css("display", "-webkit-box");
				$("#synopMore").text("더보기");
				flag.val("0");
			}
		} else {
			alert("[더보기] 추가 정보가 없습니다.");
		}
	}
</script>
<script>
	function search() {
		searchForm.submit();
	}

	function login() {
		location.href="LoginForm.jsp";
	}
	function join() {
		location.href = "Join.jsp";
	}
	function logout() {
		location.href = "Logout.jsp";
	}

	var best = document.getElementById("bestDiv");
	function show1() {
		best.style = "display:block";
	}
</script>
</html>