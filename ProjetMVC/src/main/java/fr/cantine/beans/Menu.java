package fr.cantine.beans;

import java.util.List;

public class Menu extends IndexableObject {

	private List<Plat> plats;

	public List<Plat> getPlats() {
		return plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}
	
	
}
