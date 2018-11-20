package fr.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.capgemini.beans.MatchSheet;
import fr.capgemini.dao.DaoInterface;

@Controller
public class MatchSheetController {

	@Autowired
	@Qualifier("hibernateDao")
	private DaoInterface<MatchSheet> dao;

	@GetMapping("/newMatchSheet")
	public String afficherAjouterMatchSheet() {
		return "newMatchSheet";
	}

	@PostMapping("/newMatchSheet")
	public String ajouterMatchSheet(Model model, MatchSheet matchSheet) {
		matchSheet = dao.createOrUpdate(matchSheet);

		return afficheListMatchSheet(model, "Feuille de match ajoutée : " + matchSheet.getId());
	}

	@PostMapping("/deleteMatchSheet")
	public String supprimerMatchSheet(Model model, @RequestParam Long id) {
		MatchSheet matchSheet = dao.find(id);
		dao.delete(id);

		return afficheListMatchSheet(model, "Feuille de match supprimée : " + matchSheet.getId());

	}
	
	public String afficheListMatchSheet(Model model, String message) {
		model.addAttribute("listeMatchSheet", dao.findAll());
		model.addAttribute("msg", message);

		return "newMatchSheet";

	}

}