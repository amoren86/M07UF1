<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!String nomPersona = "Clara";
	String cognoms = "Oswin";
	int edat = 3;
	LocalDate dataNaixement = LocalDate.of(1986, 3, 11);
	String telf = "935555555";
	String adrecaPostal = "Blackpool, England";
	String email = "oswin@dr.who";
	boolean treballa = false;
	float alcada = 167.23f;%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Descrivint a una Persona</title>
</head>
<body>
	<h1>Descrivint una persona</h1>
	<h2>Les dades de la persona són:</h2>
	<ul>
		<li>Es diu: <%=nomPersona + " " + cognoms%>
		</li>
		<li>Té <%=edat%> anys
		</li>
		<li>Va néixer l’any: <%=dataNaixement.toString()%>
		</li>
		<li>El seu telèfon és: <%=telf%>
		</li>
		<li>Viu a <%=adrecaPostal%>
		</li>
		<li>El seu e-mail és el <%=email%>
		</li>
		<li>i actualment <%=(treballa) ? "si" : "no"%> treballa.
		</li>
	</ul>
</body>
</html>