package fr.capgemini.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.capgemini.beans.Player;

@Transactional
public class PlayerDao implements DaoInterface<Player> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Player createOrUpdate(Player item) {
		Session session = sessionFactory.getCurrentSession();
		if(item.getId()==null) {
		session.persist(item);
		}else {
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
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Player player = find(id);
		session.remove(player);
		
	}

}