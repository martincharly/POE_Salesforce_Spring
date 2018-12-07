package fr.dawan.spring.beans;

import java.util.List;

public class Contact {

	private String nom;
	private String prenom;
	private List<String> listeAdresse; // 15 - Création d'une liste de contacts (avec getters & setters)
	

	public Contact() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<String> getListeAdresse() {
		return listeAdresse;
	}
	
	public void setListeAdresse(List<String> listeAdresse) {
		this.listeAdresse = listeAdresse;
	}
	
	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
