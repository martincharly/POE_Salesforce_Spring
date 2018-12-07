package fr.capgemini.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.capgemini.beans.Admin;
import fr.capgemini.interfaces.AdminDaoInterface;
import fr.capgemini.utils.SignUpUtil;

@Controller
public class SignUpController {
	


	@Autowired
	@Qualifier("hibernateAdminDao")
	private AdminDaoInterface adminDao;

	@GetMapping("/signup")
	public ModelAndView showSignUp() {

		return new ModelAndView("signup");
	}

	@PostMapping("/signup")
	public String addAdmin(Model model, Locale locale, @RequestParam("email") String email,
			@RequestParam("password") String password) {

		Admin admin = new Admin();

		admin.setEmail(email);
		admin.setPassword(SignUpUtil.convertToMD5(password));

		admin = adminDao.createOrUpdate(admin);

		return "login";
	}

}
