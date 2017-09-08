package fr.epf.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.MOTM;

@Singleton
public class MOTMDAO {
	private static final String COUNT_MOTM_BY_LEVEL = "SELECT COUNT(*) FROM MOTM WHERE level=";
	private static final String COUNT_ALL_MOTM = "SELECT COUNT(*) FROM MOTM";
	private static final String FIND_ALL_COMMENT_MOST_RECENT = "FROM MOTM WHERE comment <>'' ORDER BY id DESC";
	private static final String FIND_ALL_MOTM = "SELECT * FROM motm";
	@PersistenceContext
	private EntityManager em;

	public void save(MOTM motm) {
		em.persist(motm);
	}
	
	public MOTM findOne(Long id) {
		return em.find(MOTM.class, id);
	}

	public List<MOTM> findAll() {
		return em.createQuery(FIND_ALL_MOTM).getResultList();
	}

	public List<MOTM> findSome() {
		return em.createQuery(FIND_ALL_COMMENT_MOST_RECENT).getResultList();
	}
	
	public List<Long> dataCount() {
		return em.createQuery(COUNT_ALL_MOTM).getResultList();
	}
	
	public List<Long> levelCount(int level){

		return em.createQuery(COUNT_MOTM_BY_LEVEL+level).getResultList();
	}
}
