package fr.capgemini.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="Partie") 
public class Match extends DbObject {

	private String location;
	private String opponent;
	@Temporal(TemporalType.DATE)
	private Date dateMatch;
	@Enumerated(EnumType.STRING)
	private Type type;
	private int goalsScored;
	private int goalsConceded;
	
	@OneToMany(mappedBy="match")
	private List<MatchSheet> listMachSheet;
	
	public Match() {
		
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<MatchSheet> getListMachSheet() {
		return listMachSheet;
	}

	public void setListMachSheet(List<MatchSheet> listMachSheet) {
		this.listMachSheet = listMachSheet;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public int getGoalsConceded() {
		return goalsConceded;
	}

	public void setGoalsConceded(int goalsConceded) {
		this.goalsConceded = goalsConceded;
	}
	
}
