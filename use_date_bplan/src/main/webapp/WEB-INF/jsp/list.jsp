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
		<table>
			<tr>
				<th>ID</th>
				<th>名前</th>
				<th>年齢</th>
				<th>誕生日</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td><c:out value="${member.id}" /></td>
					<td><c:out value="${member.name}" /></td>
					<td><c:out value="${member.age}" /></td>
					<td><c:out value="${member.birthday}" /></td>
					<td>
						<form action="updateInput" method="get">
							<input type="hidden" name="id" value="${member.id}">
							<input type="submit" value="編集">
						</form>
					</td>					
					<td>
						<form action="deleteInput" method="get">
							<input type="hidden" name="id" value="${member.id}">
							<input type="submit" value="削除">
						</form>
					</td>					
				</tr>
			</c:forEach>
		</table>
		<p><a href="createInput">新規作成</a></p>
	</main>
</body>
</html>