<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
<style>
#logoDiv{
	width:25%;
	margin:0 auto;
	margin-top:10%;
}
#logoDiv>a{
width:100%;}
#logoDiv>a>img{
	width:100%;
}
</style>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
<link rel="stylesheet" href="css/Find2.css" type = "text/css">
</head>
<body>
<div id="logoDiv">
	<a href="MainController"><img alt="로고" src="Image/판다.png" id="logo"></a>
	</div>
<div  id="FindIdDiv">
<form action="findIdController" method="get" name="findIdForm">
<table>
<caption>아이디 찾기</caption>
<tr>
<th>이메일</th>
<td><input type="email" placeholder="이메일입력" name="findIdMail" id="IdEmail" value=""/></td>
</tr>

</table>
<input type="submit" value="찾기">
</form>
</div>
<div id="findPwDiv">
<form action="findPwController" method="post" name="findPwForm">

<table>
<caption>비밀번호 찾기</caption>
<tr>
<th>아이디</th>
<td><input type="text" placeholder="아이디입력" name="findId" id="findId"/></td>
</tr>
<tr>
<th>이메일</th>
<td><input type="email" placeholder="이메일입력" name="findMail" id="PwEmail" /></td>
</tr>
</table>
<input type="submit" value="찾기">
</form>
</div>
</body>
<script>
	var ie = document.getElementById("IdEmail");
	var pe = document.getElementById("PwEmail");
	var fe = document.getElementById("findId");
	
	ie.addEventListener("focusin",iFocusin);
	pe.addEventListener("focusin",fcsin);
	fe.addEventListener("focusin",fcsin);
	
	function iFocusin(){
	var fd = document.getElementById("FindIdDiv");
	fd.style.backgroundColor = "#f5ffdc";
	}
	
	function fcsin(){
		var fd = document.getElementById("findPwDiv");
		fd.style.backgroundColor = "#f5ffdc";
		}
</script>

</html>
