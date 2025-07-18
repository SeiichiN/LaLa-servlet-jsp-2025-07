<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${nextURL == 'createConfirm'}">
	<c:set var="h2_text" value="新規登録" />
</c:if>
<c:if test="${nextURL == 'updateConfirm'}">
	<c:set var="h2_text" value="社員情報編集" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${h2_text}</h2>
	<c:if test="${not empty errorList}">
		<ul>
		<c:forEach var="error" items="${errorList}">
			<li><c:out value="${error}" /></li>
		</c:forEach>
		</ul>
	</c:if>
	<form action="${nextURL}" method="post">
		名前：<input type="text" name="name" 
		             value="<c:out value="${memberForm.name}" />"><br>
		誕生日：<input type="text" name="birthday"
		             value="<c:out value="${memberForm.birthday}" />"
		             placeholder="xxxx/xx/xx"><br>
		<input type="submit" value="確認">
	</form>
</body>
</html>