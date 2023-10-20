<%@page import="org.w3c.dom.Node"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="javax.xml.parsers.*"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Weather</title>
<%-- Bootstrap --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<%
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String yyyyMMdd = sdf.format(now);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("https://www.aemet.es/es/api-eltiempo/prediccion/" + yyyyMMdd + "/PB/8/6908");

		Element root = doc.getDocumentElement(); //root element

		NodeList prediccio = root.getElementsByTagName("txt_prediccion");

		//Obtenim tots els nodes de tipus ciutat
		NodeList llistaCiutats = root.getElementsByTagName("ciudad");
		%>
		<h1>Weather</h1>
		<h4><%=now%></h4>
		<h3>Forecast for Barcelona province</h3>
		<p></p>
		<p>
			<%--=prediccio.item(0).getNodeValue()--%>
		</p>
		<p></p>
		<table class="table table-striped">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Min temp.</th>
				<th>Max temp.</th>
			</tr>
			<%
			//Recorrem tots els nodes ciutat, un per un
			for (int i = 0; i < llistaCiutats.getLength(); i++) {
				//Agafem el primer node ciutat ciutat
				Node ciutat = llistaCiutats.item(i);
				//Agafem tots els nodes on cadascun té les dades de la ciutat (nom, id, màxima, mínima...)
				NodeList dades = ciutat.getChildNodes();
				//Recorrem tots els nodes de dades
			%>
			<tr>
				<%
				for (int j = 0; j < dades.getLength(); j++) {
					//Agafem el primer node
					Node node = dades.item(j);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
				%>

				<td><%=node.getFirstChild().getNodeValue()%></td>
				<%
					}
				}
				%>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>
