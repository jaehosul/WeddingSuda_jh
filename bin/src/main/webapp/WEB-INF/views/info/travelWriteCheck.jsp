<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글쓰기 체크</title>
		<script type="text/javascript">
			if(${map.writeCheck == 1}) {
				alert('상품등록이 완료되었습니다.');
				location.href="./travel_list";
			}else {
				alert('상품등록이 정상적으로 이루어지지 않았습니다.');
				location.href="./travel_writeView";
			}
		</script>
	</head>
	<body>
	
	</body>
</html>