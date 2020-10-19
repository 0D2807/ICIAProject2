<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S.BS</title>
</head>
<body>
<form action="InsertController" method="post" name="boardwriteForm" enctype="multipart/form-data">
	<table>
		<tr>
			<td>비디오</td>
			<td><input type="text" name="video" size="39"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" size="39"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="20" cols="40" name="content"></textarea></td>
		</tr>		
		<tr>
			<td>책 이미지</td>
			<td><input type="file" name="image" size="39"></td>
		</tr>
		<tr>
			<td>표지</td>
			<td><input type="file" name="cover"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input type="text" name="price"></td>
		</tr>
		<tr>
			<td>사이트</td>
			<td><input type="text" name="site"></td>
		</tr>
		<tr>
			<td>출판사</td>
			<td><input type="text" name="publisher"></td>
		</tr>
		<tr>
			<td>장르</td>
			<td><input type="text" name="genre"></td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td><input type="text" name="category"></td>
		</tr>		
		<tr>
			<td>한줄 평</td>
			<td><input type="text" name="comment"></td>
		</tr>	
		<tr>
			<td>저자(/역자)</td>
			<td><input type="text" name="writer"></td>
		</tr>	
	</table>
	<button onclick="Write()">글 등록</button>
	</form>
	
</body>
<script>
function Write(){
	boardwriteForm.submit();
}
</script>
</body>
</html>