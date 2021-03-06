package fr.capgemini.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import fr.capgemini.beans.Match;
import fr.capgemini.interfaces.DaoInterface;

@Transactional
public class MatchDao implements DaoInterface<Match> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Match createOrUpdate(Match item) {
		Session session = sessionFactory.getCurrentSession();
		if(item.getId()==null) {
		session.persist(item);
		}else {
		session.merge(item);
	
		}	return item;
	}
	
	@Override
	public Match find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Match.class, id);
	}

	@Override
	public List<Match> findAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Match> query = session.createQuery("SELECT entity FROM Match entity", Match.class);
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Match match = find(id);
		session.remove(match);
		
	}

}