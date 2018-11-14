package fr.cantine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping("/{menu}/Day/{day}")
	public String getMenuForDay(
			@PathVariable("menu") String monMenu,
			@PathVariable("day") String jour,
			Model model) {
		
		model.addAttribute("le_menu", monMenu);
		model.addAttribute("le_jour", jour);
		
		
		return "menu";
	}
	
	
}
