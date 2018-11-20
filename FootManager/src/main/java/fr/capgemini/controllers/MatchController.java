package fr.capgemini.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.capgemini.beans.Match;
import fr.capgemini.beans.Type;
import fr.capgemini.dao.DaoInterface;

@Controller
public class MatchController {

	@Autowired
	@Qualifier("hibernateMatchDao")
	private DaoInterface<Match> dao;

	@GetMapping("/newMatch")
	public String afficherAjouterMatch() {
		return "newMatch";
	}

	@PostMapping("/newMatch")
	public String ajouterMatch(Model model,
			@RequestParam("location") String location,
			@RequestParam("opponent") String opponent,
			@DateTimeFormat(iso=ISO.DATE)
			@RequestParam("dateMatch") Date dateMatch,
			@RequestParam("type") Type type,
			@RequestParam("goalsScored") int goalsScored,
			@RequestParam("goalsConceded") int goalsConceded) {
		
		Match match = new Match();
		match.setLocation(location);
		match.setOpponent(opponent);
		match.setDateMatch(dateMatch);
		match.setType(type);
		match.setGoalsScored(goalsScored);
		match.setGoalsConceded(goalsConceded);
		
		match = dao.createOrUpdate(match);

		return afficheListeMatch(model, "Le match du : " + match.getDateMatch() + " a été ajouté !");
	}

	@PostMapping("/deleteMatch")
	public String supprimerMatch(Model model, @RequestParam Long id) {
		Match match = dao.find(id);
		dao.delete(id);

		return afficheListeMatch(model, "Le match du : " + match.getDateMatch() + " a été supprimé !");

	}
	
	@GetMapping("/season")
	public String afficheListeMatch(Model model, String message) {
		model.addAttribute("listeMatch", dao.findAll());
		System.out.println("afficheListeMatch");
		model.addAttribute("msg", message);

		return "season";

	}

}