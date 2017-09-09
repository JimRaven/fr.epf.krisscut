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
	
	public void update(Employee employee) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(employee.getBirth());
		String string = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE);
		em.createQuery("UPDATE Employee SET birth = '" + string + "', email = '" + employee.getEmail() + "', name = '" + employee.getName() + "', pass = '" + employee.getPass() + "' WHERE login = '" + employee.getLogin() + "'").executeUpdate();
	}
	
	public Employee findOne(Long id) {
		return em.find(Employee.class, id);
	}
	
	public List<Employee> findAll() {
		return em.createQuery("FROM Employee").getResultList();
	}

	public List<Object> findSome(String login) {
//		List<Employee> list = (List<Employee>) em.createQuery("SELECT name, pass, id, adminPriviledge FROM Employee WHERE login = '" + login + "'").getResultList();
//		System.out.println(list.get(0).getName());

		return em.createQuery(SELECT_INFO_FROM_EMPLOYEE_WHITH_LOGIN + login + "'").getResultList();
	}
}
