<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ page import="org.springframework.web.client.RestTemplate"%>
<%@ page import="com.eseo_tp_client.blo.Ville"%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	RestTemplate restTemplate = new RestTemplate(); 
	Ville[] villes = restTemplate.getForObject("http://localhost:8081/test?value=villes", Ville[].class);
	
	HttpSession session2 = request.getSession();
	session2.setAttribute("villes2", villes);
// 	out.println(villes);
	%>
	
	
	<form action="EditionVilleServ" method="post">
		<%for (int i = 0; i < villes.length; i++) {
			if (i%50 == 0 && i!=0){%>
				<br>
				<h1 style = "text-align:center;"> 
				<% out.println("Page "+i/50);%>
				<br>
				<a href="accueil.html"> Retour </a>
				</h1>
				<br>
			<%}%>
			
<!-- 			<a href="editionVille.jsp">  -->
			<h3 style = "text-align:center;"> <% out.println(villes[i].getNomCommune());%>
<!-- 			</a> -->
			<input type="radio" name="ville" value=<%=villes[i].getCodeCommuneInsee()%>> 
			<input type="submit" name="valider">
			</h3>
		<%}
		%>
	</form>
	
	
</body>
</html>