<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home.css">
	<title>학생조회</title>
</head>
<body>
<table>
	<thead>
	<tr>
	<th>이름</th><th>나이</th><th>주소</th><th></th><th></th><th></th>
	</tr>
	</thead>
	<tbody>
			${html }
	</tbody>	
</table>
	
<a href = "/school">홈으로</a>
<a href = "insert">입력하기</a>


</body>
</html>
