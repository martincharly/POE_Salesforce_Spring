package fr.capgemini.interfaces;

import java.util.List;

import fr.capgemini.beans.MatchSheet;

public interface MatchSheetDaoInterface extends DaoInterface<MatchSheet> {

	List<MatchSheet> findByMatchId (Long id);
	
}
