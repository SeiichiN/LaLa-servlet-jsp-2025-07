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
			<form action="createConfirm" method="post">
				名前：<input type="text" name="name"
				             value="<c:out value="${memberForm.name}" />"><br>
				誕生日：<input type="text" name="birthday"
				               placeholder="----/--/--"
				               value="<c:out value="${memberForm.birthday}" />"><br>
				<input type="submit" value="確認">
			</form>
		</main>
	
		<jsp:include page="common/aside.jsp" />
	</div>
</body>
</html>