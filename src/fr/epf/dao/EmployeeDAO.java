package fr.epf.dao;

import java.util.Calendar;
import java.util.Date;
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
	
	public void createDefault() {
		if(em.createQuery("FROM Employee WHERE login = 'admin' AND pass = 'admin'").getResultList().isEmpty()) {
			Calendar cal = Calendar.getInstance();
			cal.set(1980, 1, 1, 0, 0, 0);
			Date birth = cal.getTime();
			Employee employee = new Employee("admin","default.email@krisscut.com",birth,"admin","admin", 1);
			em.persist(employee);
		}
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
	
	public String getAll() {
		if(em.createQuery("SELECT * FROM Employee")==null) {
			return "fucked up";
		}else return "fucked up too";
	}
	
	public Employee findFirstByLoginAndPassword(String login, String password) {
		return (Employee)em.createQuery("FROM Employee WHERE login = '" + login + "' AND pass = '"+password + "'").getResultList().get(0);
	}

	public List<Employee> findSome(String login) {
//		List<Employee> list = (List<Employee>) em.createQuery("SELECT name, pass, id, adminPriviledge FROM Employee WHERE login = '" + login + "'").getResultList();
//		System.out.println(list.get(0).getName());

		return em.createQuery(SELECT_INFO_FROM_EMPLOYEE_WHITH_LOGIN + login + "'").getResultList();
	}
}
