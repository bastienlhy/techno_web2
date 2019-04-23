package com.eseo_tp_client.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eseo_tp_client.blo.Ville;

/**
 * Servlet implementation class AcceuilServ
 */
@WebServlet(name = "AccueilServ", urlPatterns = { "/AccueilServ" })
public class AccueilServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServ() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String codeVille1 = request.getParameter("nomVille1");
		String codeVille2 = request.getParameter("nomVille2");
		
		HttpSession session2 = request.getSession();
		Ville[] villes = (Ville[]) session2.getAttribute("villes");

		System.out.println(villes);
		Ville ville1 = null;
		Ville ville2 = null;
		for (int i = 0; i < villes.length; i++) {

			if (villes[i].getCodeCommuneInsee().equals(codeVille1)) {
				ville1 = villes[i];
			} 
			if (villes[i].getCodeCommuneInsee().equals(codeVille2)) {
				ville2 = villes[i];
			}
		}

		double distance = calculDistance(ville1, ville2);

		session2.setAttribute("nomVille1", ville1.getNomCommune());
		session2.setAttribute("nomVille2", ville2.getNomCommune());
		session2.setAttribute("distance", distance);


		RequestDispatcher dispat = request.getRequestDispatcher("VisualiserDistance.jsp");
		dispat.forward(request, response);
	}

	double calculDistance(Ville ville1, Ville ville2) {
		if (ville1.getNomCommune().equals(ville2.getNomCommune()))
			return 0;
		else {
			double lat1 = Double.parseDouble(ville1.getLattitude());
			double lat2 = Double.parseDouble(ville2.getLattitude());
			double lon1 = Double.parseDouble(ville1.getLongitude());
			double lon2 = Double.parseDouble(ville2.getLongitude());

			int R = 6371;

			double dLat = (lat2 - lat1) * (Math.PI / 180); 
			double dLon = (lon2 - lon1) * (Math.PI / 180);

			double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos((lat1) * (Math.PI / 180))
					* Math.cos((lat2) * (Math.PI / 180)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			double d = R * c; // Distance in km

			return d;
		}

	}

}
