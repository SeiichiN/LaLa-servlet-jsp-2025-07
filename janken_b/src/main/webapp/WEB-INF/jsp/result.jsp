<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Com" %>
<%
User user = (User) request.getAttribute("user");
Com com = (Com) request.getAttribute("com");
String result = (String) request.getAttribute("result");
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
		<p><%= user.showHand() %></p>
		<p><%= com.showHand() %></p>
		<p><%= result %></p>
		<p><a href="play">もう一度</a></p>
	</main>
	<footer>
		<small>&copy; 2025 NUKAYAMA</small>
	</footer>
</body>
</html>