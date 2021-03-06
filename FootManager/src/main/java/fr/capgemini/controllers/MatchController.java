package fr.capgemini.controllers;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.capgemini.beans.Match;
import fr.capgemini.beans.Type;
import fr.capgemini.interfaces.DaoInterface;

@Controller
public class MatchController {

	@Autowired
	@Qualifier("hibernateMatchDao")
	private DaoInterface<Match> dao;

	@GetMapping("/newMatch")
	public String afficherAjouterMatch() {
		return "newMatch";
	}
	
	@Autowired
	private MessageSource messageSource;
	
	@PostMapping("/newMatch")
	public String ajouterMatch(Model model, Locale locale,
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
		String result1 = messageSource.getMessage("MATCH_ADDED", new String[]{match.getDateMatch().toString()}, locale);

		return afficheListeMatch(model, result1);
	}

	@PostMapping("/deleteMatch")
	public String supprimerMatch(Model model, @RequestParam Long id, Locale locale) {
		Match match = dao.find(id);
		dao.delete(id);
		String matchDeleted = messageSource.getMessage("MATCH_DELETED", new String[]{match.getDateMatch().toString()}, locale); 
		return afficheListeMatch(model, matchDeleted);

	}
	
	@GetMapping("/season")
	public String afficheListeMatch(Model model, String message) {
		model.addAttribute("listeMatch", dao.findAll());
		model.addAttribute("msg", message);

		return "season";

	}

}