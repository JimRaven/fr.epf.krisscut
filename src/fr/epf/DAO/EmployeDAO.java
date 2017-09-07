package fr.epf.DAO;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.Model.Employe;

@Singleton
public class EmployeDAO {

	@PersistenceContext
	private EntityManager em;

	public void save(Employe employe) {
		em.persist(employe);
	}
	
	public Employe findOne(Long id) {
		return em.find(Employe.class, id);
	}

	public List<Employe> findAll() {
		return em.createQuery("SELECT * FROM Employe").getResultList();
	}

	public List<Object> findSome(String login) {
		return em.createQuery("SELECT name, pass, id, adminPriviledge FROM Employe WHERE login = '" + login + "'").getResultList();
	}
}
