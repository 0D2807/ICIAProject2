<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
 <link rel="shortcut icon" href="Image/logo_icon.ico">
</head>
<body>

</body>
<script>
  alert('${sessionScope.member.name} 님 환영합니다.');
  location.href = "MainController?viewBook=${sessionScope.member.viewBook}";
</script>
</html>