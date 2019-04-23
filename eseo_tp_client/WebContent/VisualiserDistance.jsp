<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	La distance entre
	<%=session.getAttribute("nomVille1")%>
	et
	<%=session.getAttribute("nomVille2")%>
	est de :
	<%=session.getAttribute("distance")%>
	km.

	<br>
	<a href="choixVille.jsp"> Retour </a>
	<br>
	<a href="accueil.html"> Accueil </a>

</body>
</html>