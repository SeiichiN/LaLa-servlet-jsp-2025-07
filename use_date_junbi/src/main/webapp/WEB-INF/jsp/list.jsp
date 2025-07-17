<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<jsp:include page="common/head.jsp" />
<body>
	<h1>社員管理マネージャー</h1>
	<div class="container">
		<main>
			<h2>一覧</h2>
			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>誕生日</th>
					<th>年齢</th>
					<th></th>
					<th></th>
				</tr>
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td><c:out value="${member.id}" /></td>
					<td><c:out value="${member.name}" /></td>
					<td><c:out value="${member.birthday}" /></td>
					<td><c:out value="${member.age}" /></td>
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
		</main>
		<jsp:include page="common/aside.jsp" />
	</div><!-- .container end -->
</body>
</html>