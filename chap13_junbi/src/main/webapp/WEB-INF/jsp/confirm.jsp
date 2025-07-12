<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${targetURL == 'createDone'}">
	<c:set var="gobackURL" value="createInput" />
	<c:set var="btnValue" value="登録" />
</c:if>
<c:if test="${targetURL == 'updateDone'}">
	<c:set var="gobackURL" value="updateInput" />
	<c:set var="btnValue" value="更新" />
</c:if>
<c:if test="${targetURL == 'deleteDone'}">
	<c:set var="gobackURL" value="list" />
	<c:set var="btnValue" value="削除" />
</c:if>

<!DOCTYPE html>
<html>
<jsp:include page="common/head.jsp" />
<body>
	<jsp:include page="common/header.jsp" />
	
	<div class="container">
  	<main>
  		<h2>${h2_text}</h2>
  		<div class="error">
  		  <ul>
  			<c:forEach var="errorMsg" items="${errorList}">
  			  <li><c:out value="${errorMsg}" /></li>
  			</c:forEach>
  			</ul>
  		</div>
			<table>
				<tr>
					<th>ID</th>
					<td><c:out value="${emp.id}" /></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><c:out value="${emp.name}" /></td>
				</tr>
				<tr>
				  <th>年齢</th>
				  <td><c:out value="${emp.age}" /></td>
				</tr>
			</table>
			<form action="${targetURL}" method="post">
  			    <input type="hidden" name="id" value="${emp.id}">
			    <input type="hidden" name="name" value="${emp.name}">
			    <input type="hidden" name="age" value="${emp.age}">

				<input type="submit" value="もどる"
				       formaction="${gobackURL}" formmethod="post">
				<input type="submit" value="${btnValue}">
			</form>
	  </main>
	  <jsp:include page="common/aside.jsp" />
	</div> <!-- .contaier end -->
	
  <jsp:include page="common/footer.jsp" />
</body>
</html>