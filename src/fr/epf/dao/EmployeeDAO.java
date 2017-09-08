package fr.epf.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.Employee;

@Singleton
public class EmployeeDAO {

	@PersistenceContext
	private EntityManager em;

	public void save(Employee employee) {
		em.persist(employee);
	}
	
	public Employee findOne(Long id) {
		return em.find(Employee.class, id);
	}

	public List<Employee> findAll() {
		return em.createQuery("SELECT * FROM Employee").getResultList();
	}

	public List<Object> findSome(String login) {
		return em.createQuery("SELECT name, pass, id, adminPriviledge FROM Employee WHERE login = '" + login + "'").getResultList();
	}
}
