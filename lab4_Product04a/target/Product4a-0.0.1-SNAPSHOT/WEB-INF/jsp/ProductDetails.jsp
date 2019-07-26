<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>

<%--    <c:forEach items="${categories}" var="category">--%>
<%--        ${category.name}<br/>--%>
<%--    </c:forEach>--%>

        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Category: ${product.category.name}
        Description: ${product.description}<br/>
        Price: $${product.price}
<spring:url value="/listproducts" var="list"></spring:url>
    <form:form modelAttribute="products" method="get" action="${list}">
                   <input id="submit" type="submit"
                        value="List products">

    </form:form>
    
</div>
</body>
</html>