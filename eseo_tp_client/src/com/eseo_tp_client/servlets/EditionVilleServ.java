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
 * Servlet implementation class EditionVilleServ
 */
@WebServlet("/EditionVilleServ")
public class EditionVilleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditionVilleServ() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codeVilleChoisie = request.getParameter("ville");

		HttpSession session2 = request.getSession();
		Ville[] villes = (Ville[]) session2.getAttribute("villes2");

		Ville villeChoisie = null;
		for (int i = 0; i < villes.length; i++) {
			if (villes[i].getCodeCommuneInsee().equals(codeVilleChoisie))
				villeChoisie = villes[i];
		}

		session2.setAttribute("villeChoisie", villeChoisie);


		RequestDispatcher dispat = request.getRequestDispatcher("editionVille.jsp");
		dispat.forward(request, response);
	}

}
