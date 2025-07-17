<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<jsp:include page="common/head.jsp" />
<body>
	<h1>社員情報管理マネージャー</h1>
	<div class="contaier">
		<main>
				名前：<c:out value="${memberForm.name}" /><br>
				誕生日：<c:out value="${memberForm.birthday}" /><br>
			<form action="createDone" method="post">
				<input type="hidden" name="name" value="${memberForm.name}">
				<input type="hidden" name="birthday" value="${memberForm.birthday}">
				<input type="submit" value="登録">
			</form>
		</main>
	
		<jsp:include page="common/aside.jsp" />
	</div>
</body>
</html>
