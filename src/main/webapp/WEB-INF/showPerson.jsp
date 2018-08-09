<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Details for this Person</title>
  	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<h1>${person.firstName } ${person.lastName }</h1>
	<h2>State: ${person.license.state }</h2>
	<h2>Expiration Date: ${person.license.expirationDate}</h2>
	<h2>License Number: ${person.license.number}</h2>
</body>
</html>