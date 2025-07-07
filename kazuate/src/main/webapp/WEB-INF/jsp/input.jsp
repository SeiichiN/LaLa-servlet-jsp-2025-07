<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数当てゲーム</title>
</head>
<body>
	<h1>数当てゲーム</h1>
	<p>
		私の思い浮かべた数を当ててください。<br>
		1～99の範囲です。<br>
		<form action="play" method="post">
			<input type="text" name="num">
			<input type="submit" value="これだ！">
		</form>
	</p>
	<% if (msg != null) { %>
		<p><%= msg %></p>
	<% } %>
	<p><a href="play?retry=yes">別の数字でもう一度</a></p>
</body>
</html>