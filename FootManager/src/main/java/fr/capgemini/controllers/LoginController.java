package fr.capgemini.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.capgemini.viewmodel.UserViewModel;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView ("login");
		}
	
	@PostMapping("/login")
	public ModelAndView checkLogin(UserViewModel user, HttpSession session) {
		String returnUrl = "login";
		if(user.getUserName() != null && user.getPassword() != null 
				&& user.getUserName() != "" && user.getPassword() != "" 
				&& user.getUserName().equals(user.getPassword())) {
			session.setAttribute("user", user.getUserName());
			returnUrl = "redirect:/team";
		}
		
		return new ModelAndView (returnUrl);
	}
	
}