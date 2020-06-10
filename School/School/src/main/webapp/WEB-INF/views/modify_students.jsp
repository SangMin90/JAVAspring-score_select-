<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/modify.css">
<meta charset="UTF-8">
<title>성적수정</title>
</head>
<body>
<form action="modify_action" method = "post">
	  <input type = "hidden" name ="idx" value = "${idx }" />
      이름<input type="text" name="name" placeholder = "이름" value = "${name }"/>
      <br/>
      나이<input type="number" name="age" placeholder = "나이" value = "${age }" />
      <br/>      
      주소<input type="text" name="adress" placeholder = "주소" value = "${adress }"/>
      <br/>
      
      <input type="submit" value="수정" />
    </form>
<a href = "/school">홈으로</a>
<a href = "/school/select_students">학생조회</a>
<a href = "/school/select_score">성적조회</a>


</body>
</html>