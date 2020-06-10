<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css">
<meta charset="UTF-8">
<title>입력</title>
</head>
<body>
<form action="update_action" method = "post">
	  <!-- <input type = "hidden" name ="student_no" value = "${student_no }" /> -->
      이름<input type="text" name="name" placeholder = name value = "${name }" />
      <br>
      국어점수<input type="number" name="kor" placeholder = "국어점수" value = "${kor }" />
      <br>      
      영어점수<input type="number" name="eng" placeholder = "영어점수" value = "${eng }"/>
      <br>
      수학점수<input type="number" name="math" placeholder = "수학점수" value = "${math }"/>
      <br>
      <input type="submit" value="입력" />
    </form>
<a href = "/school">홈으로</a>



</body>
</html>