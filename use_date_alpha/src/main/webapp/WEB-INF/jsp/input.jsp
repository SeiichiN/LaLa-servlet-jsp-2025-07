<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${nextURL == 'creasteConfirm'}">
	<c:set var="h2_text" value="新規社員登録" />
</c:if>
<c:if test="${nextURL == 'updateConfirm'}">
	<c:set var="h2_text" value="社員情報編集" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理プログラム</title>
</head>
<body>
	<jsp:include page="common/header.jsp" />
	<main>
		<h2>${h2_text}</h2>
		<c:if test="${not empty errorList}">
		  <ul>
				<c:forEach var="error" items="${errorList}">
				  <li class="error">${error}</li>
				</c:forEach>
			</ul>
		</c:if>
		<form action="${nextURL}" method="post">
			<c:if test="${nextURL == 'updateConfirm'}">
				ID：<c:out value="${memberForm.id}" /><br>
				<input type="hidden" name="id" value="${memberForm.id}">
			</c:if>
			名前：<input type="text" name="name" 
			             value="<c:out value="${memberForm.name}" />"><br>
			誕生日：<input type="text" name="birthday"
		      	         placeholder="xxxx/xx/xx"
		      	         value="<c:out value="${memberForm.birthday}" />"><br>
			<input type="submit" value="確認">
		</form>
	</main>
</body>
</html>