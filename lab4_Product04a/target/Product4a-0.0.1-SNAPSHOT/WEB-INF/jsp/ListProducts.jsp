<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h2>List of Products</h2>


<table>
		<tr><th>Name</th><th>Category</th><th>Description</th></tr>

	<c:forEach var="product" items = "${products}">
		<tr>
		<td>${product.name}</td>
		<td>${product.category.name}</td>
		<td>${product.description}</td>
		</tr>
	</c:forEach>
</table>

	<spring:url value="/product" var="prod"></spring:url>
	<form:form modelAttribute="product" method="get" action="${prod}">
		           <input id="submit" type="submit"
		                value="Add product">
	</form:form>

     
</div>
</body>
</html>