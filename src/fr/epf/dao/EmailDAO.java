package fr.epf.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.Email;

@Singleton
public class EmailDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Email eMail) {
		em.createQuery("DELETE FROM Email ").executeUpdate();
		em.persist(eMail);
	}

	public List<Email> findAll() {
		return em.createQuery("FROM Email").getResultList();
	}
}
