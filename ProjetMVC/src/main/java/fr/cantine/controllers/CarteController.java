package fr.cantine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cantine.beans.Plat;
import fr.cantine.dao.DaoInterface;

@Controller
@RequestMapping("/carte")
public class CarteController {
	
	@Autowired
	private DaoInterface<Plat> laCarte;
	
	
	@GetMapping("")
	public String afficheCarte (Model model) {
		
		model.addAttribute("listePlats", laCarte.findAll());
		
		return "carte";
	}

}
