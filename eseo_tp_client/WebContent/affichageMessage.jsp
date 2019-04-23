<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ page import="com.eseo_tp_client.blo.Ville"%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	La ville 
	<%Ville villeChoisie=(Ville)session.getAttribute("villeChoisie");
	out.println(villeChoisie.getNomCommune());%>
	correspondant au code INSEE 
	<%out.println(villeChoisie.getCodeCommuneInsee());%>
	a bien été modifiée.
	
	<br><br>
	<a href="accueil.html"> Accueil </a>
</body>
</html>