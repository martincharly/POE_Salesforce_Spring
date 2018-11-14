package fr.cantine.controllers;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// TODO : 1 - Création d'un Homecontroller

@Controller
public class HomeController {

	@RequestMapping(path={"/accueil", "/default"}, method=RequestMethod.GET) // On va pouvoir appeler cette méthode via /accueil et /default
//	@GetMapping(value={"/accueil", "/default"}) // On autorise l'appel de la page en Get
	public String HomePage() {
		return "home";
	}
	
	@PostMapping(value="/accueil", params= {"dateReouverture", "lieu"}) // On appelle la méthode en Post
	public String HomePost(Model model,
			@DateTimeFormat(iso=ISO.DATE)
			@RequestParam Date dateReouverture,
			@RequestParam String lieu) {
		model.addAttribute("dateDeReouverture", dateReouverture);
		model.addAttribute("lieu", lieu);
		return "homePost";
	}
	
}
