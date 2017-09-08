package fr.epf.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.MOTMDesc;

@Singleton
public class MOTMDescDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(MOTMDesc motmDesc) {
		//em.createQuery("");
		em.persist(motmDesc);
	}

	public List<MOTMDesc> findAll() {
		return em.createQuery("FROM MOTMDesc WHERE content <>''").getResultList();
	}
}
