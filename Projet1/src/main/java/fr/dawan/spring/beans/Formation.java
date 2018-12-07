package fr.dawan.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;

public class Formation implements InitializingBean {

	private String libelle;
	private int duree;
	private double prix;
	private String description;
	
	public Formation() {
		System.out.println("Formation créée");
	}
	
	public Formation(String libelle, int duree, double prix) {
		this();
		this.libelle = libelle;
		this.duree = duree;
		this.prix = prix;
	}

	public Formation(String libelle, int duree) {
		this();
		this.libelle = libelle;
		this.duree = duree;
	}

	public Formation(String libelle, String description) {
		this();
		this.libelle = libelle;
		this.description = description;
	}

	public Formation(double prix, String libelle, String description) {
		this();
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getDescription() {
		return description;
	}
	
//	@Required // Cette annotation permet de rendre obligatoire la description
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Formation [libelle=" + libelle + ", duree=" + duree + ", prix=" + prix + ", description=" + description
				+ "]";
	}
	
	
	// Généré par l'implémentation InitializingBean - permet d'effectuer des tâches après le paramétrage des propriétés
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet : " + libelle);
		
	}
	
	// Annotation similaire à l'implémentation InitializingBean
	@PostConstruct
	public void apresConstructeur() {
		System.out.println("Après le constructeur");
	}
	
	@PreDestroy
	public void avantDestroy() {
		System.out.println("Avant le destroy");
	}
	
	public void initialisationFormation() {
		System.out.println("Ici, on veut faire des trucs");
	}

	
}
