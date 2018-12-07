package fr.capgemini.beans;

import javax.persistence.Entity;

@Entity
public class Admin extends DbObject {

	private String email;
	private String password;
	
	public Admin() {
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
