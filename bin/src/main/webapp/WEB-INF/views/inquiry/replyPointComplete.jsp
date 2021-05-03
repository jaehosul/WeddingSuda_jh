<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>답변채택 포인트 지급 완료</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			alert("답변을 채택해 주셔서 감사합니다!\n\n답변 작성자에게 포인트 100점 지급이 완료되었습니다!");
			location.href="/inquiry/inquiry_main?page=${map.page}&search=${map.search}";
		</script>
	</head>
	<body>
	
	</body>
</html>