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

import fr.capgemini.beans.MatchSheet;
import fr.capgemini.beans.Player;
import fr.capgemini.beans.Position;
import fr.capgemini.dao.DaoInterface;

@Controller
public class PlayerController {

	@Autowired
	@Qualifier("hibernatePlayerDao")
	private DaoInterface<Player> dao;

	@GetMapping("/newPlayer")
	public String afficherAjouterPlayer() {
		return "newPlayer";
	}

	@PostMapping("/newPlayer")
	public String ajouterPlayer(Model model,
			@RequestParam("lastName") String lastName,
			@RequestParam("firstName") String firstName,
			@DateTimeFormat(iso=ISO.DATE)
			@RequestParam("birthday") Date date,
			@RequestParam("position") Position position,
			@RequestParam("kitNumber") int kitNumber,
			@RequestParam("email") String email
			) {
		
		Player player = new Player();
		
		player.setLastName(lastName);
		player.setFirstName(firstName);
		player.setBirthday(date);
		player.setPosition(position);
		player.setKitNumber(kitNumber);
		player.setEmail(email);

		player = dao.createOrUpdate(player);

		return afficheTeam(model, "Joueur ajouté : " + player.getLastName());
	}

	@PostMapping("/deletePlayer")
	public String supprimerPlayer(Model model, @RequestParam Long id) {
		Player player = dao.find(id);
		dao.delete(id);

		return afficheTeam(model, "Joueur supprimé : " + player.getLastName());

	}

	@GetMapping("/team")
	public String afficheTeam(Model model, String message) {
		model.addAttribute("listePlayer", dao.findAll());
		model.addAttribute("msg", message);

		return "team";

	}

}