<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>le mie carte</title>
<head>
<meta charset="ISO-8859-1">
<style>
header {
	background-color: rgba(88, 88, 88, 0.1);
	height: 120px;
	margin: 0;
}

body {
	margin: 0;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #eee;
}

button {
	background-color: #1e90ff;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 150px;
}

button:hover {
	opacity: 0.8;
}
</style>

</head>
<body>

	<header>
		<h1>Step Bank</h1>
	</header>
	<div id="logout" style="float: right">
		<a href="<c:url value="/logout" />">Logout</a>
	</div>
	<table align="center">
		<tr>
			<th>Codice carta</th>
			<th>IBAN</th>
			<th></th>
		</tr>
		<c:url var="operazione" value="/le-tue-operazioni" />
		<c:forEach items="${carte}" var="carta">
			<form name="submitForm" method="POST" action="${operazione}">
				<tr>
					<td>${carta.getIdCarta()}</td>
					<td>${carta.getIban()}</td>
					<input type="hidden" name="codice" value="${carta.getIdCarta()}" />
					<td><button type="submit">movimenti</button></td>
				</tr>
			</form>
		</c:forEach>
	</table>

</body>
</html>