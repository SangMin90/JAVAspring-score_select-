<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css">
<meta charset="UTF-8">
<title>학생입력</title>
</head>
<body>
<form action="insert_action" method = "post">
      <input type="text" name="name" placeholder = "이름" />
      <br>
      <input type="number" name="age" placeholder = "나이" />
      <br>      
      <input type="text" name="adress" placeholder = "주소" />
      <br>
      
      <input type="submit" value="입력" />
    </form>
<a href = "/school">홈으로</a>
<a href = "/school/insert_score">성적입력</a>
<a href = "/school/select_score">성적조회</a>

</body>
</html>
${alert}