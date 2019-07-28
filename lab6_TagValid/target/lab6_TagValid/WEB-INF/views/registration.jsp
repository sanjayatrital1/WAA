<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

<h1>Registration Form</h1><br />
<form:form modelAttribute="student" method="post">
    <p><label>ID</label>
        <form:input path="id"/>
        <form:errors path="id" cssStyle="color: red"/>
    </p>
    <p> <label>First Name</label>
        <form:input path="firstName"/>
        <form:errors path="firstName" cssStyle="color: red"/>
    </p>
    <p>
        <label>Last Name</label>
        <form:input path="lastName"/>
        <form:errors path="lastName" cssStyle="color: red"/>
    </p>
    <p>
        <label>Emali</label>
        <form:input path="email"/>
        <form:errors path="email" cssStyle="color: red"/>
    </p>

    <p>
        <label>Gender</label>
        <form:radiobutton path="gender" value="M"/> Male<form:radiobutton path="gender" value="F"/>Female
<%--        <form:errors path="gender"/>--%>
    </p>
    <p>
        <label>Date Of Birth</label>
        <form:input path="birthday"/>
        <form:errors path="birthday" cssStyle="color: red"/>
    </p>

    <p>
        <label>Phone</label>
        <form:input path="phone.area"/>
        <form:errors path="phone.area" cssStyle="color: red"/>
        <form:input path="phone.prefix"/>
        <form:errors path="phone.prefix" cssStyle="color: red"/>
        <form:input path="phone.number"/>
        <form:errors path="phone.number" cssStyle="color: red"/>
    </p>
    <input type="submit" value="Register User"/>

</form:form>

</body>
</html>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
</body>
</html>