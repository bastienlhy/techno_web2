package com.eseo_tp_server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VilleDAO {

	public VilleDAO() {

	}

	public ArrayList<String> requeteTrouverVilles() {
		Co co = new Co();

		String requete = "select * from ville_france ";

		ResultSet resultats = null;
		try {
			Statement stmt = co.getCo().createStatement();
			resultats = stmt.executeQuery(requete);
		} catch (SQLException e) {
			// traitement de l'exception
			System.out.println("marche pas");
		}

		ArrayList<String> villes = new ArrayList<String>();
		try {
			while (resultats.next()) {
				villes.add(resultats.getString("Code_commune_INSEE"));
				villes.add(resultats.getString("Nom_commune"));
				villes.add(resultats.getString("Code_postal"));
				villes.add(resultats.getString("Libelle_acheminement"));
				villes.add(resultats.getString("Ligne_5"));
				villes.add(resultats.getString("Latitude"));
				villes.add(resultats.getString("Longitude"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return villes;
	}

	public ArrayList<String> requeteTrouverVillesFiltre(String nomCommune, String codePostal) {
		Co co = new Co();
		String requete = null;
		if(nomCommune == null || codePostal ==null) {
			requete = "select * from ville_france where Nom_commune = \'" + nomCommune + "\' or Code_postal = \'"
				+ codePostal + "\'";
//			System.out.println("if");
		}
		else {
			requete = "select * from ville_france where Nom_commune = \'" + nomCommune + "\' and Code_postal = \'"
					+ codePostal + "\'";
//			System.out.println("else");
		}

		ResultSet resultats = null;
		try {
			Statement stmt = co.getCo().createStatement();
			resultats = stmt.executeQuery(requete);
		} catch (SQLException e) {
			// traitement de l'exception
			System.out.println("marche pas");
		}
		System.out.println(resultats);
		ArrayList<String> villes = new ArrayList<String>();
		System.out.println("ici");
		try {
//			resultats.first();
//			villes.add(resultats.getString("Code_commune_INSEE"));
//			villes.add(resultats.getString("Nom_commune"));
//			villes.add(resultats.getString("Code_postal"));
//			villes.add(resultats.getString("Libelle_acheminement"));
//			villes.add(resultats.getString("Ligne_5"));
//			villes.add(resultats.getString("Latitude"));
//			villes.add(resultats.getString("Longitude"));
			while (resultats.next()) {
				villes.add(resultats.getString("Code_commune_INSEE"));
				villes.add(resultats.getString("Nom_commune"));
				villes.add(resultats.getString("Code_postal"));
				villes.add(resultats.getString("Libelle_acheminement"));
				villes.add(resultats.getString("Ligne_5"));
				villes.add(resultats.getString("Latitude"));
				villes.add(resultats.getString("Longitude"));
				System.out.println("ici");
				System.out.println(villes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return villes;
	}

}
