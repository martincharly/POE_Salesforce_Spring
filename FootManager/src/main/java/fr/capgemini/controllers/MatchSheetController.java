package fr.capgemini.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.capgemini.beans.Match;
import fr.capgemini.beans.MatchSheet;
import fr.capgemini.beans.Player;
import fr.capgemini.dao.DaoInterface;

@Controller
public class MatchSheetController {

	@Autowired
	@Qualifier("hibernateMatchSheetDao")
	private DaoInterface<MatchSheet> matchSheetDao;

	@Autowired
	@Qualifier("hibernateMatchDao")
	private DaoInterface<Match> matchDao;

	@Autowired
	@Qualifier("hibernatePlayerDao")
	private DaoInterface<Player> playerDao;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/newMatchSheet")
	public String afficherAjouterMatchSheet(Model model) {
		return afficheListMatchSheet(model, null);
	}

	@PostMapping("/newMatchSheet")
	public String ajouterMatchSheet(Model model, Locale locale, @RequestParam("goals") int goals,
			@RequestParam("assists") int assists, @RequestParam("idPlayer") Long idPlayer,
			@RequestParam("idMatch") Long idMatch

//			@RequestParam("cards") Cards cards,
//			@RequestParam("mark") int mark

	) {

		
		MatchSheet matchSheet = new MatchSheet();
		Player player = playerDao.find(idPlayer);
		Match match = matchDao.find(idMatch);

		matchSheet.setGoals(goals);
		matchSheet.setAssists(assists);
		matchSheet.setPlayer(player);
		matchSheet.setMatch(match);
//		matchSheet.setCards(cards);
//		matchSheet.setMark(mark);
		player.setNbGoals(player.getNbGoals() + goals);
		player.setNbAssists(player.getNbAssists() + assists);
		player.setNbMatchs(player.getNbMatchs() + 1);
		
		List<MatchSheet> listMatchSheet = match.getListMachSheet();
		int goalCounter = 0;
		
		for (MatchSheet matchSheet2 : listMatchSheet) {
			// TODO : Pour chaque feuille de match, on ajoute le nombre de buts au compteur
			goalCounter += matchSheet2.getGoals();
		}
		
		if (player.getNbGoals() > match.getGoalsScored() - goalCounter) {
			String resultInconsistentGoals = messageSource.getMessage("INCONSISTENT_GOALS", null, locale);
			return afficheListMatchSheet(model, resultInconsistentGoals);
		} else {
			player = playerDao.createOrUpdate(player);
			matchSheet = matchSheetDao.createOrUpdate(matchSheet);

			return afficheListMatchSheet(model, "Feuille de match du " + match.getDateMatch() + " ajoutée pour "
					+ player.getLastName() + " " + player.getFirstName());
		}
	}

	@PostMapping("/deleteMatchSheet")
	public String supprimerMatchSheet(Model model, @RequestParam Long id) {
		MatchSheet matchSheet = matchSheetDao.find(id);
		matchSheetDao.delete(id);

		return afficheListMatchSheet(model, "Feuille de match supprimée : " + matchSheet.getId());
	}

	public String afficheListMatchSheet(Model model, String message) {
		model.addAttribute("listeMatch", matchDao.findAll());
		model.addAttribute("listePlayer", playerDao.findAll());
		model.addAttribute("msg", message);

		return "newMatchSheet";

	}

}