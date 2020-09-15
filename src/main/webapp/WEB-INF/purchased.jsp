<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase complete</title>
</head>
<body>
	<h1>Purchase complete</h1>
	<p>An order has been placed for the following items:</p>
	<c:forEach items="${user.basket}" var="item">
		<p>Name: ${item.name}</p>
		<p>Description: ${item.description}</p>
		<p>Price: &pound${item.price}</p>
		<br>
	</c:forEach>
	<div>
		<p>Total Charged: ${user.totalPrice}
	</div>
	<div>
		<a href="Return">Return to Basket</a>
	</div>
</body>
</html>