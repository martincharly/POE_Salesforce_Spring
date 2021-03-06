package fr.capgemini.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.capgemini.beans.Admin;
import fr.capgemini.beans.MatchSheet;
import fr.capgemini.interfaces.MatchSheetDaoInterface;

@Transactional
public class MatchSheetDao implements MatchSheetDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public MatchSheet createOrUpdate(MatchSheet item) {
		Session session = sessionFactory.getCurrentSession();
		if (item.getId() == null) {
			session.persist(item);
		} else {
			session.merge(item);

		}
		return item;
	}

	@Override
	public MatchSheet find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(MatchSheet.class, id);
	}

	@Override
	public List<MatchSheet> findAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<MatchSheet> query = session.createQuery("SELECT entity FROM MatchSheet entity", MatchSheet.class);
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Suppression MatchSheet " + id);
		if (id != null) {
			MatchSheet matchSheet = find(id);
			if (matchSheet != null) {
				session.remove(matchSheet);
			}
		}
	}

	@Override
	public List<MatchSheet> findByMatchId(Long idMatch) {
		
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<MatchSheet> query = session.createQuery("SELECT entity FROM MatchSheet entity WHERE entity.match.id=" + idMatch, MatchSheet.class);
		
		return query.getResultList();
		
	}

}
