<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>operazioni</title>
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
	align: center;
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
			<th>Id Operazione</th>
			<th>Luogo</th>
			<th>Tipo</th>
			<th>Importo</th>
			<th>Data</th>
			<th>Ora</th>
		</tr>
		<c:forEach items="${operazioni}" var="operazione">
			<tr>
				<td>${operazione.getIdOperazione() }</td>
				<td>${operazione.getLuogo() }</td>
				<td>${operazione.getTipo() }</td>
				<td>${operazione.getImporto()}</td>
				<td>${operazione.getData()}</td>
				<td>${operazione.getOra()}</td>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align: center;">
		<c:url var="carte" value="/le-tue-carte" />
		<form name="submitForm" method="POST" action="${carte}">
			<input type="hidden" name="username" value="${username}" />
			<button type="submit">Chiudi</button>
		</form>
	</div>
</body>
</html>
