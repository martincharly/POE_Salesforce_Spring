package fr.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.capgemini.beans.Match;
import fr.capgemini.dao.DaoInterface;

@Controller
public class SeasonController {

	@Autowired
	@Qualifier("hibernateMatchDao")
	private DaoInterface<Match> season;
	
	@GetMapping("")
	public String afficherSeason(Model model) {
		model.addAttribute("season", season.findAll());
		return "season";
	}

	public DaoInterface<Match> getSeason() {
		return season;
	}

	public void setSeason(DaoInterface<Match> season) {
		this.season = season;
	}

	
}