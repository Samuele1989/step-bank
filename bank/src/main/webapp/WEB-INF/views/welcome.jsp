<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>welcome</title>

<meta charset="ISO-8859-1">

<style>

header{
background-color: rgba(88,88,88,0.1);
height: 120px;
margin:0;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	margin:0;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #1e90ff;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 256px;
}

button:hover {
	opacity: 0.8;
}

.card {
	margin: 8px 0;
	width: 256px;
	height: 40px;
}

</style>


</head>
<body>
   <header><h1>Step Bank</h1></header>
	<div id="logout" style="float: right">
		<a href="<c:url value="/logout" />">Logout</a>
	</div>
	<div id="logout" style="float: right">
		<a href="<c:url value="/aggiungi-utente" />">Area amministratori&nbsp&nbsp&nbsp</a>
	</div>

	<h3 align="center">Benvenuto ${utente}</h3>
	<c:url var="carte" value="/le-tue-carte" />
	<form name="submitForm" method="POST" action="${carte}">
		<input type="hidden" name="username" value="${utente}" />
		<div align="center">
			<img class="card"
				src="http://legalizemaine.net/wp-content/uploads/2015/08/Credit-Card-Logos-1024x160.gif" />
			<div>
				<button type="submit">CARTE</button>
			</div>
		</div>

	</form>
</body>
</html>
