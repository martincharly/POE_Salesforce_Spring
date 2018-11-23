package fr.capgemini.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.capgemini.beans.MatchSheet;
import fr.capgemini.beans.Player;
import fr.capgemini.utils.MultiplePlayerFoundException;

@Transactional
public class PlayerDao implements DaoInterface<Player> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Player createOrUpdate(Player item) {
		Session session = sessionFactory.getCurrentSession();
		if (item.getId() == null) {
			session.persist(item);
		} else {
			session.merge(item);
		}
		return item;
	}

	@Override
	public Player find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Player.class, id);
	}

	@Override
	public List<Player> findAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Player> query = session.createQuery("SELECT entity FROM Player entity", Player.class);
		return query.getResultList();
	}
	
	@Override
	public Player findByEmail(String email) throws MultiplePlayerFoundException {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Player> query = session.createQuery("SELECT entity FROM Player entity WHERE entity.email='" + email + "'" , Player.class);
		List<Player> playerList = query.getResultList();
		
		if (playerList.size() == 1) {
			return playerList.get(0);
		}
		else if (playerList.size() > 1){
			throw new MultiplePlayerFoundException();
		}
		
		return null;
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Player player = find(id);

		if (player != null) {
			List<MatchSheet> listMatchSheet = player.getListMatchSheet();

			for (MatchSheet matchSheet : listMatchSheet) {
				deleteMatchSheet(session, matchSheet.getId());
			}
		}

		session.remove(player);

	}

	private void deleteMatchSheet(Session session, Long id) {
		if (id != null && session != null) {
			MatchSheet matchSheet = session.find(MatchSheet.class, id);
			if (id != null) {
				session.remove(matchSheet);
			}
		}
	}

}