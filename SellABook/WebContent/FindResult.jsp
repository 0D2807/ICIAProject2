<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
<style>
	body{
	background-color:#F5F5DC;
	}
</style>
</head>
<body>
<c:if test="${list != null }">

	<ul><c:forEach var="list" items="${ list}">
		<li>${list}</li>
		</c:forEach>
	</ul>
</c:if>
<c:if test="${member!=null }">
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
		</tr>
		<tr>
			<td>${member.id }</td>
			<td>${member.password }</td>
			<td>${member.email }</td>
		</tr>
	</table>
</c:if>
<button onclick="back()">돌아가기</button>
</body>

<script>
	function back(){
		window.history.back()
	}
</script>
</html>