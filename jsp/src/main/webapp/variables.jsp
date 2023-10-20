<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Àmbits de les variables a JSLT</title>
</head>
<body>
	<c:set var="test" value="Valor d’una variable d’àmbit de pàgina"
		scope="page" />
	<c:set var="test" value="Valor d’una variable d’àmbit de request"
		scope="request" />

	<c:set var="test" value="Valor d’una variable d’àmbit de sessió"
		scope="session" />

	<c:set var="test" value="Valor d’una variable d’àmbit d’aplicació"
		scope="application" />
	<h1>Àmbits de les variables a JSLT:</h1>
	<table border="1">
		<tr>
			<td><b>Àmbit per defecte: </b></td>
			<td><c:out value="${test}" /></td>
		</tr>
		<tr>
			<td><b>Àmbit de pàgina</b></td>
			<td><c:out value="${pageScope.test}" /></td>
		</tr>
		<tr>
			<td><b>Âmbit de Request: </b></td>
			<td><c:out value="${requestScope.test}" /></td>
		</tr>
		<tr>
			<td><b>Àmbit de sessió</b></td>
			<td><c:out value="${sessionScope.test}" /></td>
		</tr>
		<tr>
			<td><b>Àmbit d’aplicació</b></td>
			<td><c:out value="${applicationScope.test}" /></td>
		</tr>
	</table>
</body>
</html>