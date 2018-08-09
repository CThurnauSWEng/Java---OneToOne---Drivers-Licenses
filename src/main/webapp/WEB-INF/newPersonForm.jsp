<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>New Person</title>
 	<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>

	<h1>Add a new person to the database</h1>
	
	<form:form method="POST" action="/processNewPerson" modelAttribute="person">
	    <form:label path="firstName">First Name
	    <form:errors path="firstName"/>
	    <span>xxxxx</span>
	    <form:input path="firstName"/></form:label>

	    <form:label path="lastName">Last Name
	    <form:errors path="lastName"/>
	    <span>xxxxx</span>
	    <form:input path="lastName"/></form:label>

        <input type="submit" value="Submit"/>

	</form:form>
</body>
</html>