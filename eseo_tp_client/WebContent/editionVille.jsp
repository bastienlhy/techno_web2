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
	Vous avez sélectionné la ville nommée 
	<%Ville villeChoisie=(Ville)session.getAttribute("villeChoisie");
	out.println(villeChoisie.getNomCommune());
	villeChoisie.setNomCommune(villeChoisie.getNomCommune().replace(" ", "_"));
	villeChoisie.setLibelleAcheminement(villeChoisie.getNomCommune().replace(" ", "_"));
	%>.

	<br><br>
	Vous pouvez l'éditer ci-dessous : 
	<br><br>
	
	<form action="UpdateServ" method="post">
		Nom commune : 
		<input type="text" name="nomCommune" value=<%=villeChoisie.getNomCommune()%>>
		<br>
		Code postal : 
		<input type="text" name="codePostal" value=<%=villeChoisie.getCodePostal()%>>
		<br>
		Libellé acheminement : 
		<input type="text" name="libelle" value=<%=villeChoisie.getLibelleAcheminement()%>>
		<br>
		Ligne 5 : 
		<input type="text" name="ligne5" value=<%=villeChoisie.getLigne5()%>>
		<br>
		Latitude : 
		<input type="text" name="latitude" value=<%=villeChoisie.getLattitude()%>>
		<br>
		Longitude : 
		<input type="text" name="longitude" value=<%=villeChoisie.getLongitude()%>>
		<br>
		<input type="submit" name="valider">
	</form>
	
	<%
	villeChoisie.setNomCommune(villeChoisie.getNomCommune().replace("_", " "));
	villeChoisie.setLibelleAcheminement(villeChoisie.getNomCommune().replace("_", " "));
	%>
	
	<br><br>
	<a href="affichageVille.jsp"> Retour </a>
	<br>
	<a href="accueil.html"> Accueil </a>


</body>
</html>