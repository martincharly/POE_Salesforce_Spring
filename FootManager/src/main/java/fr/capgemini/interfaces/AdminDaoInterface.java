package fr.capgemini.interfaces;

import fr.capgemini.beans.Admin;

public interface AdminDaoInterface extends DaoInterface<Admin> {

	Admin findByEmail (String email);
	
}
