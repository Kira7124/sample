<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itwill.jsp view page</title>
</head>
<body>
	<h1>itwill.jsp</h1>
	<%="메세지 : "+ request.getAttribute("msg")%><br><br>
	<%="나이  : " + request.getAttribute("age") %><hr>
	<h3>el: ${param.msg}</h3><hr>
	<h3>modelAttribute 어노테이션을 사용하여, 정보를 전달 -> el표현식으로 출력▼</h3><hr>
	<h3>spring -el : ${msg } , ${age+100}</h3>
	<h3>spring -el : ${requestScope.msg }, ${requestScope.age +100}</h3>
	
	
</body>
</html>