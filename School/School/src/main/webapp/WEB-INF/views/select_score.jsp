<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home.css">
	<title>성적조회</title>
</head>
<body>
<table>
	<thead>
	<tr>
	<th>이름</th><th>국어점수</th><th>영어점수</th><th>수학점수</th><th></th>
	</tr>
	</thead>
	<tbody>
			${html }
	</tbody>	
</table>

<a href = "/school">홈으로</a>
<a href = "/school/insert_score">성적입력</a>

</body>
</html>
