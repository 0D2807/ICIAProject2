<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
<link rel="stylesheet" href="css/topBanner3.css" type="text/css">

<style>
a{
background-color : ;
text-decoration:none;
color:black;
}

.searchTD{
text-align:center;}
.searchContent{
	font-family: sans-serif;
				font-size: 16px;
				line-height: 2em;
				max-height: 2em;
				overflow: hidden;
				display: -webkit-box;
				-webkit-line-clamp: 1;
				-webkit-box-orient: vertical;
				
}
.searchContent:hover{
background-color:pink;
}

td{
line-height:2em;
border-bottom:1px solid black;
}

.thstyle{
padding:0;
padding-top: 4%;
padding-bottom: 5%;
line-height : 2em;
margin:0;

}

</style>
</head>
<body>
<div id="logo">
	<a href="MainController"><img src="Image/로고판다.png" alt="로고" id="logoImg"></a>
	</div>
<div id="bodydiv">
	<div id="topDiv">
		<div id="searchDiv">
		<form action="SearchController" method="GET" name="searchForm" class="form">
			<select name="searchCondition">
				<option selected disable hidden>검색조건</option>
				<option value="BCATEGORY">카테고리</option>
				<option value="BPUBLISHER">출판사</option>
				<option value="BTITLE">제목</option>
				<option value="BCONTENT">내용</option>
				<option value="BWRITER">작가</option>
			</select> 
			<input type="text" placeholder="내용" name="search" />
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
	
	<table>
	
		<tr>
			<th class="thstyle">제목</th>
			<th class="thstyle">가격(원)</th>
			<th class="thstyle">출판사</th>
			<th class="thstyle">장르</th>
			<th class="thstyle">카테고리</th>
			
		</tr>
		
		<c:forEach var="bookList" items="${bookList}">
		
			<tr>
				<td width="230px" class="searchContent"> <a href="bookView?num=${bookList.num}&page=1&id=${sessionScope.member.id}">${bookList.title}</a></td>
				<td width="60px" class="searchTD">${bookList.price}</td>
				<td width="140px" class="searchTD">${bookList.publisher}</td>
				<td width="70px" class="searchTD">${bookList.genre}</td>
				<td width="100px" class="searchTD">${bookList.category}</td>
			</tr>
			
		</c:forEach>



	</table>
	
<button onclick="back()">뒤로가기</button>
</div>

</body>
<!-- topScript -->
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
</script>
<!-- 뒤로가기 -->
<script>
function back(){		 
    window.history.back();
}
</script>
</html>