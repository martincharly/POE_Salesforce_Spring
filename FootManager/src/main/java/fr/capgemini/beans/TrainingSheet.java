package fr.capgemini.beans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class TrainingSheet extends DbObject {

	private int idPlayer;
	private boolean present;
	private int implication;
	private boolean late;
	
	@ManyToOne 
	private Training training;
	


	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public TrainingSheet() {
		
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public int getImplication() {
		return implication;
	}

	public void setImplication(int implication) {
		this.implication = implication;
	}

	public boolean isLate() {
		return late;
	}

	public void setLate(boolean late) {
		this.late = late;
	}
	
	
}
