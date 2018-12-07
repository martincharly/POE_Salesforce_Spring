package fr.capgemini.interfaces;

import fr.capgemini.beans.Player;
import fr.capgemini.utils.MultiplePlayerFoundException;

public interface PlayerDaoInterface extends DaoInterface<Player> {

	Player findByEmail (String email) throws MultiplePlayerFoundException;
	
}
