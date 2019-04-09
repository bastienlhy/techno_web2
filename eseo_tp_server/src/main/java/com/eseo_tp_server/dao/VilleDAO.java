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
		if (nomCommune == null || codePostal == null) {
			requete = "select * from ville_france where Nom_commune = \'" + nomCommune + "\' or Code_postal = \'"
					+ codePostal + "\'";
		} else {
			requete = "select * from ville_france where Nom_commune = \'" + nomCommune + "\' and Code_postal = \'"
					+ codePostal + "\'";
		}

		ResultSet resultats = null;
		try {
			Statement stmt = co.getCo().createStatement();
			resultats = stmt.executeQuery(requete);
		} catch (SQLException e) {

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

	public String creerVille(String codeCommuneInsee, String nomCommune, String codePostal, String libelleAcheminement,
			String ligne5, String lattitude, String longitude) {
		
		Co co = new Co();
		String requete = "INSERT INTO ville_france(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES (\'"
				+ codeCommuneInsee + "\', \'" + nomCommune + "\', \'" + codePostal + "\', \'" + libelleAcheminement
				+ "\', \'" + ligne5 + "\', \'" + lattitude + "\', \'" + longitude + "\')";

		try {
			Statement stmt = co.getCo().createStatement();
			stmt.executeUpdate(requete);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return codeCommuneInsee + " " + nomCommune + " " + codePostal + " " + libelleAcheminement + " " + ligne5 + " "
				+ lattitude + " " + longitude;
	}

	public String modifierVille(String colonneModifiee, String valeurModif, String Code_commune_INSEE) {
		Co co = new Co();
		String update = "UPDATE ville_france SET " + colonneModifiee + " = \'" + valeurModif
				+ "\'WHERE Code_commune_INSEE = \'" + Code_commune_INSEE + "\'";

		try {
			Statement stmt = co.getCo().createStatement();
			stmt.executeUpdate(update);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return colonneModifiee + " : " + valeurModif + "Code_commune_INSEE : " + Code_commune_INSEE;
	}

	public String supprimerVille(String Code_commune_INSEE) {
		Co co = new Co();
		String update = "DELETE FROM ville_france WHERE Code_commune_INSEE = " + Code_commune_INSEE;
		try {
			Statement stmt = co.getCo().createStatement();
			stmt.executeUpdate(update);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "La ville possédant le code commune INSEE : " + Code_commune_INSEE + " a bien été supprimée de la bdd";
	}

}
