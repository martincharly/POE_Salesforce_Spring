package fr.cantine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home2")
public class Home2Controller {

	@RequestMapping("/demo")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/demo/{param1}")
	public String homeWithParam(Model model,
			@PathVariable String param1) {
		model.addAttribute("param1", param1);
		return "homeParam";
	}
	
}
