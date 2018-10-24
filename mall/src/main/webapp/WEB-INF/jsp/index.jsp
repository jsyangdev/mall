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
	<%-- Hello <%=request.getAttribute("model") %> --%> 
	<br>
	Hello ${model}
	<br>
	<!--  if(){} -->
	<c:if test="${member.level == 0}">
		일반고객
	</c:if>
	<c:if test="${member.level == 1}">
		관리자
	</c:if>
	<!-- for(String s : arr) -->
	<c:forEach var="str" items="${list}">
		<div>${str}</div>
	</c:forEach>
</body>
</html>