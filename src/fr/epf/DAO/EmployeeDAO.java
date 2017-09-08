package fr.epf.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.Employee;

@Singleton
public class EmployeeDAO {

	private static final String SELECT_INFO_FROM_EMPLOYEE_WHITH_LOGIN = "SELECT name, pass, id, adminPriviledge FROM Employee WHERE login = '";
	private static final String SELECT_EMPLOYEE_ID = "SELECT id FROM Employee";
	@PersistenceContext
	private EntityManager em;

	public void save(Employee employee) {
		em.persist(employee);
	}
	
	public Employee findOne(Long id) {
		return em.find(Employee.class, id);
	}
	
	public List<Object> findAll() {
		return em.createQuery(SELECT_EMPLOYEE_ID).getResultList();
	}

	public List<Object> findSome(String login) {
		return em.createQuery(SELECT_INFO_FROM_EMPLOYEE_WHITH_LOGIN + login + "'").getResultList();
	}
}
