<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUSTOMER RELATIONSHIP MANAGEMENT</title>
</head>
<body>
	<div align="center">
		<h1>Customer List</h1>
		<h3>
			<a href="/newCustomer">Add Customer</a>
		</h3>
		<table border="1">
		<tr>
			<th>Customer ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
			<c:forEach var="customer" items="${listContact}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td><a href="/editCustomer?id=${customer.cust_ID}">Update</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/deleteContact?id=${customer.cust_ID}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>