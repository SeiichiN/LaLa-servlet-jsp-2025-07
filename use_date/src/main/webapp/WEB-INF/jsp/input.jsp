<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理プログラム</title>
</head>
<body>
	<h1>社員情報管理プログラム</h1>
	<main>
		<h2>新規社員情報作成</h2>
		
		<form action="createConfirm" method="post">
			名前：<input type="text" name="name"><br>
			誕生日：<input type="text" name="birthday"
		      	         placeholder="xxxx/xx/xx"><br>
			<input type="submit" value="確認">
		</form>
	</main>
</body>
</html>