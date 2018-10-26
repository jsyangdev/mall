<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${loginMember != null}">
		${loginMember}님 반갑습니다.
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>
	<c:if test="${member.level == null}">	
		<a href="${pageContext.request.contextPath}/login">로그인</a>
	</c:if>		
</body>
</html>