<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${nextURL == 'createDone'}">
  <c:set var="h2_text" value="新規社員登録・確認" />
  <c:set var="btn_text" value="登録" />
</c:if>
<c:if test="${nextURL == 'updateDone'}">
  <c:set var="h2_text" value="社員情報編集・確認" />
  <c:set var="btn_text" value="更新" />
</c:if>
<c:if test="${nextURL == 'deleteDone'}">
  <c:set var="h2_text" value="社員情報削除・確認" />
  <c:set var="btn_text" value="削除" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/header.jsp" />

	<main>
		<h2>${h2_text}</h2>
		<c:if test="${nextURL == 'updateDone' || nextURL == 'deleteDone'}">
			ID：<c:out value="${memberForm.id}" /><br>
		</c:if>
		名前：<c:out value="${memberForm.name}" /><br>
		誕生日：<c:out value="${memberForm.birthday}" /><br>
		<form action="${nextURL}" method="post">
			<c:if test="${nextURL == 'updateDone' || nextURL == 'deleteDone'}">
				<input type="hidden" name="id" value="${memberForm.id}">
			</c:if>
			<input type="hidden" name="name" value="${memberForm.name}">
			<input type="hidden" name="birthday" value="${memberForm.birthday}">
			<input type="submit" value="${btn_text}">
		</form>
	</main>
</body>
</html>