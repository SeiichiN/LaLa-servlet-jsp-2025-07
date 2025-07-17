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
			<h2>新規社員登録・結果</h2>
			<c:out value="${msg}" />
			<a href="list"><button type="button">一覧へ</button></a>
		</main>
		<jsp:include page="common/aside.jsp" />
	</div><!-- .container end -->
</body>
</html>