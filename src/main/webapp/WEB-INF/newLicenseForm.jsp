<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>New License</title>
 	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<h1>Add a license to a person</h1>
	
    <form:form method="POST" action="/processNewLicense" modelAttribute="license">
  
	    <form:label path="person">Person
	    <select name="person">
	 		<c:forEach var="person" items="${allPersons }">
	    		<option label="${person.firstName} ${person.lastName }" value="${person.id }"></option>
	    	</c:forEach>
	    </select></form:label>
	    <p></p>

    
        <form:label path="state">State
        <form:errors path="state"/>
        <form:input path="state"/></form:label>
        <h1></h1>
    
        <form:label path="expirationDate">Expiration Date
        <form:errors path="expirationDate"/>
        <form:input type="date" path="expirationDate"/></form:label>
        <h1></h1>
                
        <input type="submit" value="Submit"/>
    </form:form>

</body>
</html>