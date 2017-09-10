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
	private static final String FIND_ALL_COMMENT_MOST_RECENT = "FROM MOTM WHERE comment <>'' AND visible = 1 ORDER BY id DESC";
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

	public List<MOTM> findRecentPublicComment() {
		return em.createQuery(FIND_ALL_COMMENT_MOST_RECENT).getResultList();
	}
	
	public int dataCount() {
		int result = 0;
		List<Long> resultList= em.createQuery(COUNT_ALL_MOTM).getResultList();
		if(!resultList.isEmpty()) {
			result = Math.toIntExact(resultList.get(0));
		}
		return result;
	}
	
	public int levelCount(int level){
		int result = 0;
		List<Long> resultList= em.createQuery(COUNT_MOTM_BY_LEVEL+level).getResultList();
		if(!resultList.isEmpty()) {
			result = Math.toIntExact(resultList.get(0));
		}
		return result;
	}
}
