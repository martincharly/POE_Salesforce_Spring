package fr.capgemini.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.capgemini.beans.Admin;
import fr.capgemini.beans.Player;
import fr.capgemini.interfaces.AdminDaoInterface;
import fr.capgemini.utils.MultiplePlayerFoundException;

@Transactional
public class AdminDao implements AdminDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Admin createOrUpdate(Admin item) {
		Session session = sessionFactory.getCurrentSession();
		if(item.getId()==null) {
		session.persist(item);
		}else {
		session.merge(item);
	
		}	return item;
	}

	@Override
	public Admin find(Long id) {
		return null;
	}

	@Override
	public Admin findByEmail(String email) {
		
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Admin> query = session.createQuery("SELECT entity FROM Admin entity WHERE entity.email='" + email + "'" , Admin.class);
		List<Admin> adminList = query.getResultList();
		
		if (adminList.size() == 1) {
			return adminList.get(0);
		}
		
		return null;
	}

	@Override
	public List<Admin> findAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Admin> query = session.createQuery("SELECT entity FROM Admin entity", Admin.class);
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		
	}
	
}
