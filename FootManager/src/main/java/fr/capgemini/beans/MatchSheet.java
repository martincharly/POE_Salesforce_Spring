package fr.capgemini.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class MatchSheet extends DbObject{

	private int goals;
	private int assists;
//	@Enumerated(EnumType.STRING)
//	private Cards cards;
//	private int mark;
	
	@ManyToOne  
	private Match match;
	@ManyToOne
	private Player player;
	
	public MatchSheet() {
		
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}
	
//	public Cards getCards() {
//		return cards;
//	}
//
//	public void setCards(Cards cards) {
//		this.cards = cards;
//	}
//
//	public int getMark() {
//		return mark;
//	}
//
//	public void setMark(int mark) {
//		this.mark = mark;
//	}

	
}
