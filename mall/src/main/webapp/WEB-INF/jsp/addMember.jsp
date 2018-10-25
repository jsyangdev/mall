<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>addMember Form</h2>
	<form action="<%=request.getContextPath()%>/addMember" method="post">
		id : <input type="text" name="id"><br>
		pw : <input type="text" name="pw"><br>
		level : <input type="number" name="level"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>