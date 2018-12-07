package fr.dawan.spring.beans;

import java.util.List;
import java.util.Map;

// TODO : 13 - Création d'un catalogue (liste de formations)
public class Catalogue {

	private List<Formation> listeFormation;
	private Map<Integer, String> formations; // TODO : 16 - Création d'une Map

	public List<Formation> getListeFormation() {
		return listeFormation;
	}
	
	public void setListeFormation(List<Formation> listeFormation) {
		this.listeFormation = listeFormation;
	}
	
	public Map<Integer, String> getFormations() {
		return formations;
	}

	public void setFormations(Map<Integer, String> formations) {
		this.formations = formations;
	}

}
