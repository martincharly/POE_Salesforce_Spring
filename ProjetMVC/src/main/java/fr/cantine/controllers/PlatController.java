package fr.cantine.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		
		plat = dao.createOrUpdate(plat);
		
		return afficheCarte(model, "Nouveau plat ajouté : " + plat);
	}
	
	@PostMapping("/delete")
	public String supprimerPlat(Model model, @RequestParam Long id) {
		
		Plat plat = dao.findById(id);
		dao.delete(id);
		
		return afficheCarte(model, "Plat supprimé : " + plat.getNom());
	}
	
	
	@PostMapping("/upload")
	public String ajoutImage(Model model,
			HttpServletRequest request,
			@RequestParam("id") Long id, 
			@RequestParam("image_plat") MultipartFile file) {

		// Création du répertoire de stockage de notre image
		String path = request.getServletContext().getRealPath("uploaded");
		
		System.out.println(path);
		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		
		// On indique son emplacement (directory) et son nouveau nom (Date+nom d'origine)
		try {
			File fichierDestination = new File(directory, new Date().getTime() + "_" + file.getOriginalFilename());
			FileOutputStream stream = new FileOutputStream(fichierDestination);
			stream.write(file.getBytes());
			stream.close();
			
			Plat plat = dao.findById(id);
			plat.setImage(fichierDestination.getName());
			dao.createOrUpdate(plat);
			
			return afficheCarte(model, "Fichier uploadé : " + fichierDestination.getName());
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			return afficheCarte(model, "Erreur dans l'upload !");
			
		}
		
	}
	
	private String afficheCarte(Model model, String message) {

		model.addAttribute("listePlats", dao.findAll());
		model.addAttribute("msg", message);
		
		return "carte";
	}
	
	
	
}
