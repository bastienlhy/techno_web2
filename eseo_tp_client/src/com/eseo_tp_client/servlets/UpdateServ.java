package com.eseo_tp_client.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.client.RestTemplate;

import com.eseo_tp_client.blo.Ville;

/**
 * Servlet implementation class UpdateServ
 */
@WebServlet("/UpdateServ")
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServ() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomCommune = request.getParameter("nomCommune");
		String codePostal = request.getParameter("codePostal");
		String libelle = request.getParameter("libelle");
		String ligne5 = request.getParameter("ligne5");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");

		HttpSession session = request.getSession();
		Ville villeChoisie = (Ville) session.getAttribute("villeChoisie");

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.put("http://localhost:8081/put?Code_commune_INSEE=" + villeChoisie.getCodeCommuneInsee()
				+ "&nomCommune=" + nomCommune, String.class);
		restTemplate.put("http://localhost:8081/put?Code_commune_INSEE=" + villeChoisie.getCodeCommuneInsee()
				+ "&codePostal=" + codePostal, String.class);
		restTemplate.put("http://localhost:8081/put?Code_commune_INSEE=" + villeChoisie.getCodeCommuneInsee()
				+ "&libelleAcheminement=" + libelle, String.class);
		restTemplate.put("http://localhost:8081/put?Code_commune_INSEE=" + villeChoisie.getCodeCommuneInsee()
				+ "&ligne5=" + ligne5, String.class);
		restTemplate.put("http://localhost:8081/put?Code_commune_INSEE=" + villeChoisie.getCodeCommuneInsee()
				+ "&latitude=" + latitude, String.class);
		restTemplate.put("http://localhost:8081/put?Code_commune_INSEE=" + villeChoisie.getCodeCommuneInsee()
				+ "&longitude=" + longitude, String.class);

		RequestDispatcher dispat = request.getRequestDispatcher("affichageMessage.jsp");
		dispat.forward(request, response);

	}

}
