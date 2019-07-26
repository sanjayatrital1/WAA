 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

 <!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
<%--<form action="product" method="post">--%>
    <spring:url value="/product" var="product_url"></spring:url>
    <form:form modelAttribute="product" action="${product_url}">
    <fieldset>
        <legend>Add a product</legend>
        <p>
            <label>Category </label>
            <form:select path="category.id">
                <form:option value="-1">---Select Category---</form:option>
                <form:options items="${categories}" itemLabel="name" itemValue="id"></form:options>

            </form:select>
        </p>
         
        <p>
            <spring:message code="product.name"/>
<%--            Product Name:--%>
            <form:input path="name" tabindex="1"/>
        </p>
        <p>
            <spring:message code="product.description"/>
<%--            Product Description:--%>
            <form:input path="description" tabindex="2"/>

        </p>
        <p>
            <spring:message code="product.price"/>
<%--            Price:--%>
            <form:input path="price" tabindex="3"/>

        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Add Product">
        </p>
    </fieldset>

    </form:form>
</div>
</body>
</html>
