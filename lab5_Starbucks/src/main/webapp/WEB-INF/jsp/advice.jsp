 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<title>Starbuck's</title>
</head>
<body>
<c:choose>
	<c:when test="${username eq null}">
		<h2>You need to Log In to select roast</h2>
		<form action="login" method="get">
			<input type="submit" value="Log In"/>
		</form>
	</c:when>
	<c:otherwise>
		<h2>Welcome ${username.name}</h2>

<h2>Ask for advice about your favorite roast:</h2>
<p />
<form action = "roastList" method="post">
	<select name="roastKey"   >
	   	<option value="-">  --Select Roast-- </option>
		
		  		<c:forEach var="roast" items="${roasts}">
		    		<option value="${roast.key}" > ${roast.value}</option>
				</c:forEach>
		    </select>
 
 	<p><input type="submit" value = "Submit"/></p>
</form>

<form action="logout" method="get">
	<input type="submit" value="logout">
</form>
	</c:otherwise>

</c:choose>
 </body>
</html>