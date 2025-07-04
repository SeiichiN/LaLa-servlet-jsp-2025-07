<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD:janken_a/src/main/webapp/WEB-INF/jsp/result.jsp
<%@ page import="model.User" %>
<%
User user = (User) request.getAttribute("user");
=======
<%@ page import="model.GameManager" %>
<%
GameManager manager = (GameManager)request.getAttribute("manager");
>>>>>>> main:janken/src/main/webapp/WEB-INF/jsp/result.jsp
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>じゃんけんゲーム</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>
		<h1>じゃんけんゲーム</h1>
	</header>
	<main>
<<<<<<< HEAD:janken_a/src/main/webapp/WEB-INF/jsp/result.jsp
		<p><%= user.getResult() %></p>
=======
		<p><%= manager.getHands() %></p>
		<p><%= manager.getResult() %></p>
>>>>>>> main:janken/src/main/webapp/WEB-INF/jsp/result.jsp
		<p><a href="play">もう一度</a></p>
	</main>
	<footer>
		<small>&copy; 2025 NUKAYAMA</small>
	</footer>
</body>
</html>