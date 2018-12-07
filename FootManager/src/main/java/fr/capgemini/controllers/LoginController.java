package fr.capgemini.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.capgemini.beans.Admin;
import fr.capgemini.interfaces.AdminDaoInterface;
import fr.capgemini.utils.MultiplePlayerFoundException;
import fr.capgemini.utils.SignUpUtil;

@Controller
public class LoginController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("hibernateAdminDao")
	private AdminDaoInterface adminDao;

	@GetMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}

	@PostMapping("/login")
	public String checkLogin(Model model, Locale locale, Admin admin, HttpSession session, String message) throws MultiplePlayerFoundException {

//		String returnUrl = "login"; 
//		Admin adminList = adminDao.findByEmail(admin.getEmail());
//		for (Admin admin2 : adminList) {
		
		Admin admin2 = adminDao.findByEmail(admin.getEmail());
			if (admin.getEmail().equals(admin2.getEmail()) && (admin.getEmail() != null)
					&& (!admin.getEmail().equals("")) && (admin.getPassword() != null) && (admin.getPassword() != "")
					&& (admin2.getPassword().equals(SignUpUtil.convertToMD5(admin.getPassword())))) {
				session.setAttribute("user", admin2);

				return "redirect:player/team";
			}
			
		String resultLoginError = messageSource.getMessage("LOGIN_ERROR", null, locale);
		return loginError(model, resultLoginError);
	}

	public String loginError(Model model, String message) {
		model.addAttribute("msg", message);
		return "login";
	}

}

//		try {
//			adminFromDb = adminDao.findByEmail(admin.get);
//		} catch (MultiplePlayerFoundException e) {
//			return afficheTeam(model, "HOULA ! GROS PROBLEME ! Plusieurs joueurs avec cet e-mail, contactez rapidement votre administrateur, c'est quoi ce bordel ?");
//		}
//		if (user.getEmail() != null && user.getPassword() != null && user.getEmail() != ""
//				&& user.getPassword() != "") {
//			session.setAttribute("user", user.getEmail());
//			returnUrl = "redirect:player/team";
//		}
//
//		return new ModelAndView(returnUrl);
