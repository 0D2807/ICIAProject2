<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
<meta charset="UTF-8">
<title>S.BS</title>
<link rel="stylesheet" href="css/Index2.css" type="text/css">
<style>
@import url(https://fonts.googleapis.com/earlyaccess/nanumpenscript.css);
.text {font-family: 'Nanum Pen Script', cursive;
font-size:1.8rem;
}
</style>
</head>
<body>
	<div id="info">

	<a href="MainController"><img src="Image/판다 책.png" alt="S.BS"/></a>

		<h3 class="text">※클릭시 메인화면으로 이동합니다.※</h3>
		<table>
			<tr>
				<td class="noticeText">공지사항</td>
				<td class="noticeText">작성일</td>
			</tr>
			<c:forEach var="notice" items="${notice}">
				<tr>
					<td class="noticeContent">${notice.content }</td>
					<td class="noticeDate">${notice.date }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>