<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione utente</title>
</head>
<body>
	<div id="logout" style="float: right">
		<a href="<c:url value="/logout" />">Logout</a>
	</div>
	<h2>Inserisci i dati</h2>
	<form:form method="POST" modelAttribute="nuovoUtente">
		<label for="username">Username</label>
		<form:input type="text" id="username" path="username" />
		<br />
		<label for="password">Password</label>
		<form:input type="password" id="password" path="password" />
		<br />
		<label for="nome">Nome</label>
		<form:input type="text" id="nome" path="nome" />
		<br />
		<label for="cognome">Cognome</label>
		<form:input type="text" id="cognome" path="cognome" />
		<br />
		<label for="ruolo">Ruolo</label>
		<form:radiobutton path="ruolo" value="ROLE_ADMIN" /> Amministratore
		<form:radiobutton path="ruolo" value="ROLE_USER" /> Utente
		<br />
<%-- 		<form:input type="hidden" id="enabled" path="enabled" value="true" /> --%>
		<input type="submit" id="submitButton" value="Aggiungi">
	</form:form>
</body>
</html>