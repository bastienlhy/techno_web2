<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ page import="org.springframework.web.client.RestTemplate"%>
<%@ page import="com.eseo_tp_client.blo.Ville"%>
<%@ page import="javax.servlet.http.*"%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		RestTemplate restTemplate = new RestTemplate();
		Ville[] villes = restTemplate.getForObject("http://localhost:8081/test?value=villes", Ville[].class);
		String[] noms = new String[villes.length];
		String[] codeCommune = new String[villes.length];

		HttpSession session2 = request.getSession();
		session2.setAttribute("villes", villes);
		//  	int k=0;
		for (int i = 0; i < villes.length; i++) {
			noms[i] = villes[i].getNomCommune();
			codeCommune[i] = villes[i].getCodeCommuneInsee();
			// 		if (villes[i] == null)
			// 			++k;
			// 		out.println("k : ");
			// 		out.println(k);
			// 		out.println("<br>");
		}
	%>

	<form action="AccueilServ" method="post">
		<select name="nomVille1">
			<%
				for (int i = 0; i < noms.length; i++) {
			%>
			<option value=<%out.println(codeCommune[i]);%>>
				<%
					out.println(noms[i]);
				%>
			</option>
			<%
				}
			%>
		</select> <select name="nomVille2">
			<%
				for (int i = 0; i < noms.length; i++) {
			%>
			<option value=<%out.println(codeCommune[i]);%>>
				<%
					out.println(noms[i]);
				%>
			</option>
			<%
				}
			%>
		</select> <input type="submit" name="valider">

		<%-- 		<input type="hidden" name="villes" value = <%=villes%>> --%>
	</form>
	
	<br>
	<a href="accueil.html"> Retour </a>


</body>
</html>