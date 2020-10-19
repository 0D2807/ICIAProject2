<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">



<title>S.BS</title>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
<link rel="stylesheet" href="css/topBanner3.css" type="text/css">
<link rel="stylesheet" href="css/bookList2.css" type="text/css">


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

					<c:when test="${sessionScope.memberId == null}">
						
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
		<div id="topImg">
		
		<c:forEach var="book" items="${bookList }">
			<div class="bookListImg">
			<img src="Image/${book.image}" alt="${book.title}"/>
</div>
		</c:forEach>
		</div>
		<div id="left"> 
			<a class="a" href="bookList?category1=동화,유아">동화/유아</a> <br />
			<a class="a" href="bookList?category1=만화">만화</a> <br /> <a class="a"
				href="bookList?category1=잡지">잡지</a> <br /> <a class="a"
				href="bookList?category1=IT,과학">IT/과학</a> <br /> <a class="a"
				href="bookList?category1=소설"> 소설</a> <br /> <a class="a"
				href="bookList?category1=자기계발">자기계발</a> <br /> <a class="a"
				href="bookList?category1=취미,건강">취미/건강</a> <br /> <a class="a"
				href="bookList?category1=경제">경제</a> <br /> <a class="a"
				href="bookList?category1=시,에세이">시/에세이</a> <br /> <a class="a"
				href="bookList?category1=종교,예술">종교/예술</a> <br /> <a class="a"
				href="bookList?category1=교재,수험서">교재/수험서</a> <br /> <a class="a"
				href="bookList?category1=인문,역사">인문/역사</a> <br />
			<c:if test="${sessionScope.member.id eq 'admin' }">
				<button onclick="button()" id="addBook">책추가</button>
			</c:if>
		</div>
	<div id="bookTable">
		<table>
			<tr>
				<td class="bookList">제목</td>
				<td class="bookList">가격</td>
				<td class="bookList">출판사</td>
				<td class="bookList">장르</td>
				<td class="bookList">카테고리</td>
			</tr>
			<c:forEach var="book" items="${bookList }">
				<tr>
					<td class="bookList"><button
							onclick="location.href='bookView?${book.num }'"
							onmouseover="location.href='PageAssi?title=${book.title }&category1=${book.category }&page=${paging.page }'">${book.title }</button></td>
					<td class="bookList">${book.price }원</td>
					<td class="bookList">${book.publisher }</td>
					<td class="bookList">${book.genre }</td>
					<td class="bookList">${book.category }</td>
				</tr>


			</c:forEach>

		</table>
		<c:if test="${paging.page<=1 }">[이전]&nbsp;</c:if>
		<c:if test="${paging.page>1 }">
			<a href="bookList?page=${paging.page-1 }&category1=소설">[이전]</a>&nbsp;</c:if>

		<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			var="i" step="1">
			<c:choose>
				<c:when test="${i eq paging.page }">
		${i}
	</c:when>
				<c:otherwise>
					<a href="bookList?page=${i}&category1=${category}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${paging.page>=paging.maxPage }">[다음]</c:if>
		<c:if test="${paging.page<paging.maxPage }">
			<a href="bookList?page=${paging.page+1 }&category1=${category}">[다음]</a>&nbsp;</c:if>
</div>

		<div id="insertDiv">
			<%@include file="Writer.jsp"%>
		</div>
		
	</div>
</body>
<script>

function button(){
	var insert = document.getElementById("insertDiv");
	insert.style = "display:block";
	}
</script>
<script>
<%--  function BookProcess(){
	 location.href="bookView?$<%=num %>&page=${paging.page }";
 } --%>
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
	location.href ="LoginCheck.jsp";
	}

	var best = document.getElementById("bestDiv");
	function show1() {
		best.style = "display:block";
	}
</script>


</html>