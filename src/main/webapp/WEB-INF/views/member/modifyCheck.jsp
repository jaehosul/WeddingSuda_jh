<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>modifyCheck</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${check == 1}">
				<script type="text/javascript">
					alert("회원정보수정이 완료되었습니다!");
					location.href='/main/main';
				</script>	
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					alert("회원정보수정에 실패하였습니다.");
					location.href='/member/userInfoModify_pwdCheck';
				</script>	
			</c:otherwise>
		</c:choose>
	</body>
</html>