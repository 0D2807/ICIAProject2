<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
<link rel="stylesheet" href="css/join.css" type = "text/css">
</head>
<body>
<h2 id="topText">회원가입</h2>
<div id="joinField">
<div id="logoDiv">
<a href="MainController"><img src="Image/로고판다.png" alt="로고" id="logo"></a>
</div>
<form action="JoinController" method="POST" name="joinForm">
<table>
 <tr>
 	<th>아이디</th>
 	<td><input type="text" name="joinId" class="joinInput"></td>
 </tr>
  <tr>
 	<th>비밀번호</th>
 	<td><input type="password" name="joinPw" class="joinInput"></td>
 </tr>
 <tr>
 	<th>e-mail</th>
 	<td><input type="email" name="joinMail" class="joinInput"></td>
 </tr>
 <tr>
 	<th>이름</th>
 	<td><input type="text" name="joinName" class="joinInput"></td>
 </tr>
</table>
</form>
<div id="joinbtn">

<button onclick="join()">가입하기</button><br/>
<button onclick="back()">뒤로가기</button>
</div>
</div>
</body>
<script>
	function join(){
		joinForm.submit();
	}
	function back(){		 
	    window.history.back();
	}
</script>
</html>