package fr.capgemini.beans;

import javax.persistence.Entity;

@Entity 
public class Training extends DbObject {

	private int idTraining;

	public Training() {
		
	}

	public int getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}
	
}
