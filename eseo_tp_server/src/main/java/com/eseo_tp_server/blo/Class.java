package com.eseo_tp_server.blo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class {

	public void requeteTrouverVilles() {
		Co co = new Co();

		String requete = "select * from ville_france";

		ResultSet resultats = null;
		try {
			Statement stmt = co.getCo().createStatement();
			resultats = stmt.executeQuery(requete);
		} catch (SQLException e) {
			// traitement de l'exception
			System.out.println("marche pas");
		}
		
		try {
			while (resultats.next()) {
				System.out.println(resultats.getString("Nom_commune"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
