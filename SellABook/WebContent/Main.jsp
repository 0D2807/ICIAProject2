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
<link rel="stylesheet" href="css/remote2.css" type="text/css">
<link rel="stylesheet" href="css/nav2.css" type="text/css">
<link rel="stylesheet" href="css/Main2.css" type="text/css">

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
<div id="imageSlideDiv">
		<div class="slideshow-container">

			<div class="mySlides fade">
					<c:choose>
		 	<c:when test="${sessionScope.member.id!=null}">
				<a href="bookView?num=488&page=1"><img src="Image/보그_잡지.jpg" style="width: 100%; height: 300px"></a>
				</c:when>
				<c:otherwise>
				<a href="LoginCheck.jsp"><img src="Image/보그_잡지.jpg" style="width: 100%; height: 300px"></a>
				</c:otherwise>
				</c:choose>
			</div>

			<div class="mySlides fade">
				<c:choose>
		 	<c:when test="${sessionScope.member.id!=null}">
				<a href="bookView?num=375&page=1"><img src="Image/나미야 잡화점의 기적_영화.jpg" style="width: 100%; height: 300px"></a>
				</c:when>
				<c:otherwise>
				<a href="LoginCheck.jsp"><img src="Image/나미야 잡화점의 기적_영화.jpg" style="width: 100%; height: 300px"></a>
				</c:otherwise>
				</c:choose>
				
			</div>

			<div class="mySlides fade">
			<c:choose>
		 	<c:when test="${sessionScope.member.id!=null}">
				<a href="bookView?num=406&page=1"><img src="Image/알라딘-영화.jpg" style="width: 100%; height: 300px"></a>
				</c:when>
				<c:otherwise>
				<a href="LoginCheck.jsp"><img src="Image/알라딘-영화.jpg" style="width: 100%; height: 300px"></a>
				</c:otherwise>
				</c:choose>
				
			</div>

			<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
				onclick="plusSlides(1)">&#10095;</a>

		</div>
		<br>

		<div style="text-align: center">
			<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
				onclick="currentSlide(2)"></span> <span class="dot"
				onclick="currentSlide(3)"></span>
		</div>
	</div>

	<div id="categoryDiv">
		<ul>
			<li><a href="Mainpage?category=동화,유아">동화,유아</a></li>
			<li><a href="Mainpage?category=만화">만화</a></li>
			<li><a href="Mainpage?category=잡지">잡지</a></li>
			<li><a href="Mainpage?category=IT,과학">IT,과학</a></li>
			<li><a href="Mainpage?category=소설">소설</a></li>
			<li><a href="Mainpage?category=자기계발">자기계발</a></li>
			<li><a href="Mainpage?category=취미,건강">취미,건강</a></li>
			<li><a href="Mainpage?category=경제">경제</a></li>
			<li><a href="Mainpage?category=시,에세이">시,에세이</a></li>
			<li><a href="Mainpage?category=종교,예술">종교,예술</a></li>
			<li><a href="Mainpage?category=교재,수험서">교재,수험서</a></li>
			<li><a href="Mainpage?category=인문,역사">인문,역사</a></li>
		</ul>
	</div>

	<div id="bestDiv">
		<session id="topText">
		<h2 id="bestText">best3</h2>
		</session>
	
		<c:forEach var="bestList" items="${bestList }">
		<div class="best">
			<div class="bestImg">
				<c:choose>
		 	<c:when test="${sessionScope.member.id!=null}">
		 	<a href="bookView?num=${bestList.num}&id=${sessionScope.member.id}&page=1"><img
				 src="Image/${bestList.image}" alt="사진" class="categoryImg"/></a>
		 	</c:when>
		 	<c:otherwise>
		 	<input type="image" src="Image/${bestList.image}" alt="사진" onclick="biLogin()" class="categoryImg"/>
		 	</c:otherwise>
		 	</c:choose>

			
			
				</div>
				<div class="bestListDiv">
			<table>
				<tr>
					<th class="bestListTH">제목</th>
					<td>${bestList.title}</td>
				</tr>
				<tr>
					<th class="bestListTH">가격</th>
					<td>${bestList.price }</td>
				</tr>
				<tr>
					<th class="bestListTH">한줄소개</th>
					<td><p class="multiline">${bestList.comment}</p></td>
				</tr>
			</table>
		
			</div>
			
			</div>
		</c:forEach>
		
	</div>
	</div><!-- bodyDiv끝 -->
	<div id="remoteDiv">
	 <h4 id="remoteMent">[최근 본 도서]</h4>
		<c:choose>
			<c:when test="${viewBook == null}">
				<p>최근 본 도서가 없습니다.</p> 
			</c:when>
			<c:otherwise>
			<div id="remoteImg">
				<a href="bookView?num=${viewBook.num}&page=1">
				<img src="Image/${viewBook.cover}" alt="표지" /></a>
				</div>
				<div id="remoteContent">
			${viewBook.title}<br />
			${viewBook.price} 원
			</div>
		</c:otherwise>
		</c:choose>
	</div>
	
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  
 <p><a id = "a" href ="#topDiv">맨위로</a></p> 
</body>
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
	function biLogin(){
		alert("로그인이 필요합니다.")
		location.href="LoginForm.jsp";
	}
</script>

<script>
	var slideIndex = 0;
	showSlides();

	function showSlides() {
		var i;
		var slides = document.getElementsByClassName("mySlides");
		var dots = document.getElementsByClassName("dot");
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		slideIndex++;
		if (slideIndex > slides.length) {
			slideIndex = 1
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" active", "");
		}
		slides[slideIndex - 1].style.display = "block";
		dots[slideIndex - 1].className += " active";
		setTimeout(showSlides, 3500); // Change image every 2 seconds
	}
	
</script>
</html>