<%--
  Created by IntelliJ IDEA.
  User: sanjaya
  Date: 7/23/2019
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<title>RESULTS</title>
</head>
<body>

<h4>${param.greeting}</h4>

<form  >
    <input name="add1" type="text" size = "2" readonly value="${calculator.add1}"/>+
    <input name="add2" type="text" size = "2" readonly value="${calculator.add2}"/>=
    <input name="sum" type="text" size = "4"  readonly value="${calculator.sum}"/>
    <br>
    <input name="add3" type="text" size = "2" readonly   value="${calculator.mult1}"/>*
    <input name="add4" type="text" size = "2" readonly   value="${calculator.mult2}"/>=
    <input name="product" type="text" size = "4" readonly value="${calculator.prod}"/>
    <br>
    <button type=button onclick=window.location.href="Calculator">Back</button>
</form>
</body>
</html>
