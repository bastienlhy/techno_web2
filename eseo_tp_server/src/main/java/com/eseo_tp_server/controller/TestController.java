package com.eseo_tp_server.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eseo_tp_server.dao.VilleDAO;

@RestController
public class TestController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam(required = false, value = "value") String value) {
		String resultats = "";

		VilleDAO villeDAO = new VilleDAO();
		ArrayList<String> villes = new ArrayList<String>();
		if (value.equals("villes")) {
			villes = villeDAO.requeteTrouverVilles();
			for (int i = 0; i < villes.size(); i++) {
				resultats += villes.get(i) + " ";
				if (i%7==0 && i!=0)
					resultats += "<br>"; 
			}
		}

		return resultats;
	}

	@RequestMapping(value = "/testFiltre", method = RequestMethod.GET)
	@ResponseBody
	public String getFiltre(@RequestParam(required = false, value = "nom") String nom,
			@RequestParam(required = false, value = "codePostal") String codePostal) {
		
		String resultats = "";
		VilleDAO villeDAO = new VilleDAO();
		ArrayList<String> villes = new ArrayList<String>();
		
		villes = villeDAO.requeteTrouverVillesFiltre(nom, codePostal);
		for (int i = 0; i < villes.size(); i++) {
			resultats += villes.get(i) + " ";
			if (i%7==0 && i!=0)
				resultats += "<br>";
		}
		
		return resultats;
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@ResponseBody
	public String post(@RequestParam(required = true, value = "Code_commune_INSEE") String codeCommuneInsee,
			@RequestParam(required = true, value = "nomCommune") String nomCommune,
			@RequestParam(required = true, value = "codePostal") String codePostal,
			@RequestParam(required = true, value = "libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value = "ligne5") String ligne5,
			@RequestParam(required = true, value = "lattitude") String lattitude,
			@RequestParam(required = true, value = "longitude") String longitude) {
		//param SOAP UI : 
		//?nomCommune=THORIGNE&codePostal=49220&libelleAcheminement=THORIGNE&ligne5=ligne5&lattitude=100&longitude=16&Code_commune_INSEE=00000
				
		VilleDAO villeDAO = new VilleDAO();
		
		return villeDAO.creerVille(codeCommuneInsee, nomCommune, codePostal, libelleAcheminement, ligne5, lattitude, longitude);
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam(required = true, value = "Code_commune_INSEE") String codeCommuneInsee) {
		//param SOAP UI : 
		//?Code_commune_INSEE=00000
				
		VilleDAO villeDAO = new VilleDAO();
		
		return villeDAO.supprimerVille(codeCommuneInsee);
	}
}
