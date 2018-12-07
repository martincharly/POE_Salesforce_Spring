package fr.dawan.spring.utils;

import fr.dawan.spring.beans.Stagiaire;

//TODO : 12 - Création d'un identifiant de type DW-XXX-123456 avec un StringBuilder
public class RandomNumberGenerator implements NumberGenerator {

	public String computeNumber(Stagiaire stagiaire) {
		int random = (int)(Math.random() * 1000000);
		StringBuilder code = new StringBuilder();
		code.append("DW-");
		code.append(stagiaire.getNom().toUpperCase().substring(0, 3));
		code.append("-");
		code.append(random);
		
		return code.toString();
	}
	
}
