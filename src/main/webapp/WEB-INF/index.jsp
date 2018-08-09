<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Relationships</title>
  	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<h1>Hello from Relationships</h1>
	<a href="/persons/new">Add a new person</a>
	<a href="/licenses/new">Add a new license</a>
	

	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>State</th>
				<th>Number</th>
				<th>Expiration Date</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${allPersons }" var = "person">
				<tr>
					<td>
						<a href="/persons/${person.id}">${person.firstName }</a>
					</td>
					<td>${person.lastName }</td>
					<td>${person.license.state }</td>
					<td>${person.license.number }</td>
					<td>${person.license.expirationDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
</body>
</html>