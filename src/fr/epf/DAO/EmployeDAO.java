package fr.epf.DAO;

import java.util.Calendar;
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
	
	public void update(Employe employe) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(employe.getBirth());
		String string = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE);
		em.createQuery("UPDATE Employe SET birth = '" + string + "', email = '" + employe.getEmail() + "', name = '" + employe.getName() + "', pass = '" + employe.getPass() + "' WHERE login = '" + employe.getLogin() + "'").executeUpdate();
	}
	
	public Employe findOne(Long id) {
		return em.find(Employe.class, id);
	}
	
	public List<Employe> findAll() {
		return em.createQuery("FROM Employe").getResultList();
	}

	public List<Object> findSome(String login) {
//		List<Employe> list = (List<Employe>) em.createQuery("SELECT name, pass, id, adminPriviledge FROM Employe WHERE login = '" + login + "'").getResultList();
//		System.out.println(list.get(0).getName());

		return em.createQuery("SELECT name, pass, id, adminPriviledge FROM Employe WHERE login = '" + login + "'").getResultList();
	}
}
