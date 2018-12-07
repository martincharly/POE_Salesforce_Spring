package fr.dawan.spring.utils;

import fr.dawan.spring.beans.Stagiaire;



public class IncrementalNumberGenerator implements NumberGenerator {

	private int compteur;
	private int pas;
	
	
	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public int getPas() {
		return pas;
	}

	public void setPas(int pas) {
		this.pas = pas;
	}


	@Override
	public String computeNumber(Stagiaire stagiaire) {
		
		compteur = compteur + pas;
		StringBuilder code = new StringBuilder();
		code.append("DAWAN-");
		code.append(stagiaire.getNom().toUpperCase());
		code.append("-");
		code.append(compteur);
		
		return code.toString();
		
	}

}
