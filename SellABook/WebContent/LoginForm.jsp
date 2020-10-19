<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
<link rel="stylesheet" href="css/LoginForm2.css" type = "text/css">
<style>
#findText{
	width:50%;
	text-align:center;
	margin:0 auto;
}
#findText>p>a{
text-decoration: none;
color:#C0C0C0;}
#findText>p>a:hover{
text-decoration:underline;
}
</style>
</head>
<body>
<h2 id="topText">로그인</h2>
<div id="loginField">
	<div id="logoDiv">
	<a href="MainController"><img alt="로고" src="Image/판다 책.png" id="logo"></a>
	</div>
	<div id = "loginTable">
   <form action="LoginController" method="POST" name="loginForm">
	<table>
	 
		<tr>
			<td><input type="text" placeholder="아이디" id = "loginId" name="loginId" value=""></td><br>
		</tr>
		<tr>
			<td><input type="password" placeholder="비밀번호" id="loginPw"name="loginPw" value=""></td>

		</tr>
	</table>
</form>		
		<div id="btnDiv">
		<button onclick = "login()" id="loginbtn">로그인</button>
		<button onclick="join()" id="joinbtn">회원가입</button>
		</div>
		</div>
		<div id="findText">
		<p><a href="Find.jsp">아이디/비밀번호찾기</a><p>
		</div>
</div>
</body>
<script>
function join(){
	location.href = "Join.jsp";
	
}
function login() {
	loginForm.submit();
}

</script>
</html>