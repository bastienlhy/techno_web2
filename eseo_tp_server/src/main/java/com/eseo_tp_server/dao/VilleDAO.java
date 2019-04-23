package com.eseo_tp_server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.eseo_tp_server.blo.Ville;

public class VilleDAO {

	public VilleDAO() {

	}

	public Ville[] requeteTrouverVilles() {
		Co co = new Co();

		String requete = "select * from ville_france ";
//		String requeteCount = "select COUNT(*) as nbVilles FROM `ville_france";

		ResultSet resultats = null;
		try {
			Statement stmt = co.getCo().createStatement();
			resultats = stmt.executeQuery(requete);
		} catch (SQLException e) {

		}


		Ville[] villes = new Ville[3352];
		
		
		try {
			int i = 0;
			while (resultats.next()) {
				villes[i] = new Ville(resultats.getString("Code_commune_INSEE"), resultats.getString("Nom_commune"),
						resultats.getString("Code_postal"), resultats.getString("Libelle_acheminement"),
						resultats.getString("Ligne_5"), resultats.getString("Latitude"),
						resultats.getString("Longitude"));
				++i;
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

	public String modifierVille(String Code_commune_INSEE, String nomCommune, String codePostal, String libelle,
			String ligne5, String latitude, String longitude) {
		Co co = new Co();
		String updateNomCommune = "UPDATE ville_france SET Nom_commune = \'" + nomCommune
				+ "\'WHERE Code_commune_INSEE = \'" + Code_commune_INSEE + "\'";
		String updateCodePostal = "UPDATE ville_france SET Code_postal = \'" + codePostal
				+ "\'WHERE Code_commune_INSEE = \'" + Code_commune_INSEE + "\'";
		String updateLibelle = "UPDATE ville_france SET Libelle_acheminement = \'" + libelle
				+ "\'WHERE Code_commune_INSEE = \'" + Code_commune_INSEE + "\'";
		String updateLigne5 = "UPDATE ville_france SET Ligne_5 = \'" + ligne5 + "\'WHERE Code_commune_INSEE = \'"
				+ Code_commune_INSEE + "\'";
		String updateLatitude = "UPDATE ville_france SET Latitude = \'" + latitude + "\'WHERE Code_commune_INSEE = \'"
				+ Code_commune_INSEE + "\'";
		String updateLongitude = "UPDATE ville_france SET Longitude = \'" + longitude
				+ "\'WHERE Code_commune_INSEE = \'" + Code_commune_INSEE + "\'";

		try {
			Statement stmt = co.getCo().createStatement();
			if (nomCommune != null)
				stmt.executeUpdate(updateNomCommune);
			if (codePostal != null)
				stmt.executeUpdate(updateCodePostal);
			if (libelle != null)
				stmt.executeUpdate(updateLibelle);
			if (ligne5 != null)
				stmt.executeUpdate(updateLigne5);
			if (latitude != null)
				stmt.executeUpdate(updateLatitude);
			if (longitude != null)
				stmt.executeUpdate(updateLongitude);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "La modification de la commune possèdant le Code_commune_INSEE : " + Code_commune_INSEE
				+ " a été réalisée.";
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
