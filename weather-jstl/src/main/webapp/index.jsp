<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<title>Weather JSTL</title>
<%-- Bootstrap --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate var="yyyyMMdd" value="${now}" pattern="yyyy-MM-dd" />
	
	<c:import var="doc"
		url="https://www.aemet.es/es/api-eltiempo/prediccion/${yyyyMMdd}/PB/8/6908" />
	<x:parse var="parsedDoc" doc="${doc}" />

	<div class="container">
		<h1>Weather</h1>
		<h4><fmt:formatDate value="${now}" dateStyle="full" /></h4>
		<h3>Forecast for Barcelona province</h3>
		<p></p>
		<p>
			<x:out select="$parsedDoc/root/prediccion/txt_prediccion" />
		</p>
		<p></p>
		<table class="table table-striped">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Min temp.</th>
				<th>Max temp.</th>
			</tr>
			<x:forEach select="$parsedDoc/root/prediccion/ciudad">
				<tr>
					<td>
						<x:out select="id" />
					</td>
					<td>
						<x:out select="nombre" />
					</td>
					<td>
						<x:out select="minima" />
					</td>
					<td>
						<x:out select="maxima" />
					</td>
				</tr>
			</x:forEach>
		</table>
	</div>
</body>
</html>
