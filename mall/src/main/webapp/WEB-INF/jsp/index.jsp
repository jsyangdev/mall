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
		${loginMember}�� �ݰ����ϴ�.
		<a href="${pageContext.request.contextPath}/logout">�α׾ƿ�</a>
	</c:if>
	<c:if test="${member.level == null}">	
		<a href="${pageContext.request.contextPath}/login">�α���</a>
	</c:if>		
</body>
</html>