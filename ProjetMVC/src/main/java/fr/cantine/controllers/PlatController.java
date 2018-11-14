package fr.cantine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.cantine.beans.Plat;
import fr.cantine.dao.DaoInterface;

@Controller
@RequestMapping("/plat")
public class PlatController {
	
	@Autowired
	private DaoInterface<Plat> dao;
	
	@GetMapping("/new")
	public String afficherAjouterPlat() {
		return "newPlat";
	}
	
//	@PostMapping("/new")
//	public String ajouterPlat(Model model,
//			@RequestParam TypePlat typePlat, // On stipule le name saisit dans le input
//			@RequestParam float prix,
//			@RequestParam String nom
//			) {
//		
//		System.out.println(typePlat + nom + prix);
//		
//		Plat plat = new Plat();
//		plat.setTypePlat(typePlat);
//		plat.setNom(nom);
//		plat.setPrix(prix);
//		
//		plat = dao.createOrUpdate(plat);
//		
//		model.addAttribute("listePlats", dao.findAll());
//		model.addAttribute("msg", "Nouveau plat ajouté : " + plat);
//		return "carte";
//	}
	
	@PostMapping("/new")
	public String ajouterPlat(Model model, Plat plat) {
		
		System.out.println(plat);
		
		plat = dao.createOrUpdate(plat);
		
		model.addAttribute("listePlats", dao.findAll());
		model.addAttribute("msg", "Nouveau plat ajouté : " + plat);
		return "carte";
	}
	
	@PostMapping("/delete")
	public String supprimerPlat(Model model, @RequestParam Long id) {
		
		Plat plat = dao.findById(id);
		dao.delete(id);
		
		model.addAttribute("listePlats", dao.findAll());
		model.addAttribute("msg", "Plat supprimé : " + plat.getNom());
		
		return "carte";
	}
	
}
