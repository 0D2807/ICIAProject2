<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
</head>
<body onload="load()">
<form action="bookView" method="POST" name="testForm">
	<input type="hidden" name="num" value="${num}"/>
	<input type="hidden" name="page" value="${page }"/>
</form>
</body>
<script>
	function load(){
		testForm.submit();
	}
</script>
</html>