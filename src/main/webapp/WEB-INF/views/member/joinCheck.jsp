<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JoinCheck</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${check == 1}">
				<script type="text/javascript">
					location.href='/member/joinComplete';
				</script>	
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					alert("회원가입에 실패하였습니다!");
					location.href='/member/join';
				</script>	
				
			</c:otherwise>
		</c:choose>
	</body>
</html>