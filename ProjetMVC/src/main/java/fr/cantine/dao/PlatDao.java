package fr.cantine.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cantine.beans.Plat;


@Transactional
public class PlatDao implements DaoInterface<Plat> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Plat createOrUpdate(Plat item) {
		Session session = sessionFactory.getCurrentSession();
		if (item.getId() == null) {
			session.persist(item);
		} 
		else {
			session.merge(item);
		}
		return item;	
	}

	@Override
	public Plat findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Plat.class,  id);
	}

	@Override
	public List<Plat> findAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Plat> query = session.createQuery("SELECT entity FROM Plat entity", Plat.class);
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Plat plat = findById(id);
		session.remove(plat);
		
	}

}
