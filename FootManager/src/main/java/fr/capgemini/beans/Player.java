package fr.capgemini.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
public class Player extends DbObject {

	
	private String firstName;
	private String lastName;
	private Date birthday;
	private int kitNumber;
	@Enumerated(EnumType.STRING)
	private Position position;
	private String email;
	private int nbGoals;
	private int nbAssists;
//	private int nbCards
	
	@OneToMany
	private List<MatchSheet> listMatchSheet = new ArrayList<MatchSheet>();
	
	@OneToMany 
	private List<TrainingSheet> listTrainingSheet = new ArrayList<TrainingSheet>();
	
	public List<TrainingSheet> getListTrainingSheet() {
		return listTrainingSheet;
	}

	public void setListTrainingSheet(List<TrainingSheet> listTrainingSheet) {
		this.listTrainingSheet = listTrainingSheet;
	}

	public List<MatchSheet> getListMatchSheet() {
		return listMatchSheet;
	}

	public void setListMatchSheet(List<MatchSheet> listMatchSheet) {
		this.listMatchSheet = listMatchSheet;
	}

	public Player() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getKitNumber() {
		return kitNumber;
	}

	public void setKitNumber(int kitNumber) {
		this.kitNumber = kitNumber;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNbGoals() {
		return nbGoals;
	}

	public void setNbGoals(int nbGoals) {
		this.nbGoals = nbGoals;
	}

	public int getNbAssists() {
		return nbAssists;
	}

	public void setNbAssists(int nbAssists) {
		this.nbAssists = nbAssists;
	}

	
	
}
