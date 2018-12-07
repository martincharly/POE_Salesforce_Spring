package fr.dawan.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.dawan.spring.utils.NumberGenerator;

public class Stagiaire extends Contact {

	private String codeStagiaire;
	@Autowired
	@Qualifier("incrementalGenerator")
	private NumberGenerator generator;

	
	public String getCodeStagiaire() {
		return codeStagiaire;
	}

	public void setCodeStagiaire(String codeStagiaire) {
		this.codeStagiaire = codeStagiaire;
	}
	
//	public RandomNumberGenerator getGenerator() {
//		return generator;
//	}
//
//	public void setGenerator(RandomNumberGenerator generator) {
//		this.generator = generator;
//	}

	public void init() {
		setCodeStagiaire(generator.computeNumber(this));
	}
	
	@Override
	public String toString() {
		return "Stagaire [codeStagiaire=" + codeStagiaire + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ "]";
	}
	
	
}
