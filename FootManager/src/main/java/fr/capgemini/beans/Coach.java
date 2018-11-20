package fr.capgemini.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Coach extends DbObject {

	private String firstName;
	private String lastName;
	
	@OneToMany 
	private List<Player> listPlayer = new ArrayList<Player>();
	
	
	public List<Player> getListPlayer() {
		return listPlayer;
	}

	public void setListPlayer(List<Player> listPlayer) {
		this.listPlayer = listPlayer;
	}

	public Coach() {
		
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
	
	
}
