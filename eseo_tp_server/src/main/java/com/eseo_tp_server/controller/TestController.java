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
		System.out.println(nom);
		System.out.println(codePostal);
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
}
