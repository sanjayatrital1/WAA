<%--
  Created by IntelliJ IDEA.
  User: sanjaya
  Date: 7/23/2019
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/mystyle.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CALCULATOR</title>
</head>
<body>

<c:if test="${error != null}">

    <p id="errors">
        Error(s)!
    <ul>
        <c:forEach var="error" items="${error}">
            <li>${error}</li>
        </c:forEach>
    </ul>

</c:if>

<h4>Calculator</h4>

<form action="calculatorResult" method="post">
    <input name="add1" type="text" size = "2" />+
    <input name="add2" type="text" size = "2"   />=
    <input name="sum" type="text" size = "4"  readonly />
    <br>
    <input name="mult1" type="text" size = "2"  />*
    <input name="mult2" type="text" size = "2"  />=
    <input name="product" type="text" size = "4"   readonly/>
    <br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
