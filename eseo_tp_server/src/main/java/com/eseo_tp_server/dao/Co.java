package com.eseo_tp_server.dao;


import java.sql.*;

public class Co {
	
	Connection connexion;
	
	public Co() {
		this.connexion = connecterDB();
	}
	
	public Connection getCo() {
		return this.connexion;
	}

	// fonction permettant la connection � la base de donn�es
	public static Connection connecterDB() {
		try {
//			Class.forName("org.postgresql.Driver"); // chemin du driver
			// URL de connexion, nom d'utilisateur, mot de passe
			String url = "jdbc:mysql://localhost/maven";
			String nomUtilisateur = "root";
			String mdp = "";
			// Connexion � la base de donn�es
			Connection co = DriverManager.getConnection(url, nomUtilisateur, mdp);
			return co;
		} catch (Exception e) {// catch au cas o� la connexion �choue
			e.printStackTrace();
			return null;
		}
	}

	

}
