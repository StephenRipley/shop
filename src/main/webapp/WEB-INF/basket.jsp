<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Basket</title>
</head>
<body>
<a href="Logout">Log out</a>
<div>
	<p><b>${errorMessage}</b></p>
</div>
<div>
	<h1>${user.firstname} ${user.lastname}'s Basket</h1>
	<c:forEach items="${user.basket}" var="item">
		<p>Name: ${item.name}</p>
		<p>Description: ${item.description}</p>
		<p>Price: &pound${item.price}</p>
		<p>Stock: ${item.stock}</p>
		<br>
	</c:forEach>

	<c:if test="${not empty user.basket}">
		<p><b>Total Price: &pound${user.totalPrice}</b><p>
	<br>
		<a href="BuyBasket?id=${user.user_id}">Purchase basket</a>
	</c:if>
	<c:if test="${empty user.basket}">
		<p>You have no items in your baskets</p>
	</c:if>
</div>
</body>
</html>