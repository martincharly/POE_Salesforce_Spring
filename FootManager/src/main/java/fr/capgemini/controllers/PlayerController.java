package fr.capgemini.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.capgemini.beans.MatchSheet;
import fr.capgemini.beans.Player;
import fr.capgemini.beans.Position;
import fr.capgemini.dao.DaoInterface;
import fr.capgemini.dao.MatchSheetDao;
import fr.capgemini.utils.EmailUtil;
import fr.capgemini.utils.MultiplePlayerFoundException;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	@Qualifier("hibernatePlayerDao")
	private DaoInterface<Player> playerDao;

	@Autowired
	@Qualifier("hibernateMatchSheetDao")
	private DaoInterface<MatchSheet> matchSheetDao;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/newPlayer")
	public String afficherAjouterPlayer() {
		return "newPlayer";
	}

	@PostMapping("/newPlayer")
	public String ajouterPlayer(Model model, Locale locale, @RequestParam("lastName") String lastName,
			@RequestParam("firstName") String firstName,
			@DateTimeFormat(iso = ISO.DATE) @RequestParam("birthday") Date date,
			@RequestParam("position") Position position, @RequestParam("kitNumber") int kitNumber,
			@RequestParam("email") String email) {

		Player player = new Player();

		player.setLastName(lastName);
		player.setFirstName(firstName);
		player.setBirthday(date);
		player.setPosition(position);
		player.setKitNumber(kitNumber);
		player.setEmail(email);

		Player playerFromDb = null;
		
		try {
			playerFromDb = playerDao.findByEmail(player.getEmail());
		} catch (MultiplePlayerFoundException e) {
			return afficheTeam(model, "HOULA ! GROS PROBLEME ! Plusieurs joueurs avec cet e-mail, contactez rapidement votre administrateur, c'est quoi ce bordel ?");
		}

		// opération sur l'objet qui risque de faire planté le programme
		if (playerFromDb == null) {
			player = playerDao.createOrUpdate(player);
			System.out.println("c'est nul");
			String result1 = messageSource.getMessage("PLAYER_ADDED",
					new String[] { player.getLastName(), player.getFirstName() }, locale);

			return afficheTeam(model, result1);

		} else {
			System.out.println("C BIENNNNNNN!!!!!!!!!!!!!!!!!!!");
			String resultFalse = messageSource.getMessage("PLAYER__ALREADY_EXISTS",
					new String[] { player.getLastName(), player.getFirstName() }, locale);
			return afficheTeam(model, resultFalse);
		}
	}

	@PostMapping("/delete")
	public String supprimerPlayer(Model model, Locale locale, @RequestParam Long id) {

		Player player = playerDao.find(id);
		String result2 = messageSource.getMessage("PLAYER_DELETED",
				new String[] { player.getLastName(), player.getFirstName() }, locale);

//		List<MatchSheet> listMatchSheet = player.getListMatchSheet();
//		System.out.println("Nb matchSheet " + listMatchSheet.size());
//		
//		for (MatchSheet matchSheet : listMatchSheet) {
//			System.out.println("Suppression matchSheet id : " + matchSheet.getId());
//			matchSheetDao.delete(matchSheet.getId());
//		}

		System.out.println("playerDao.delete");
		playerDao.delete(id);

		return afficheTeam(model, result2);
	}

	@GetMapping("/team")
	public String afficheTeam(Model model, String message) {
		model.addAttribute("listePlayer", playerDao.findAll());
		model.addAttribute("msg", message);

		return "team";
	}

	@PostMapping("/convoque")
	public String sendMail(Model model, Locale locale, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result3 = null;
		String mailTo = request.getParameter("mailTo");
		String sujet = request.getParameter("sujet");
		String msg = request.getParameter("msg");

		if (msg != null && mailTo != null && sujet != null) {
			try {
				EmailUtil.sendEmail(messageSource.getMessage("EMAIL_SENDER", null, locale), mailTo, sujet, msg);

				result3 = messageSource.getMessage("EMAIL_SUCCESS", new String[] { mailTo }, locale);
			} catch (Exception e) {
				result3 = messageSource.getMessage("EMAIL_FAIL", null, locale);
				e.printStackTrace();
			}

		} else {
			result3 = messageSource.getMessage("EMAIL_MISSING_FIELD", null, locale);
		}
		return afficheTeam(model, result3);
	}

}