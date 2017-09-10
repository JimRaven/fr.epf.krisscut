package fr.epf.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private Date birth;
	private String login;
	private String pass;
	private int adminPriviledge;
	
	// Empty constructor called on requests
	public Employee() {
		super();
	}

	// Complete constructor when an administrator add a new employee
	public Employee(String name, String email, Date birth, String login, String pass, int adminPriviledge) {
		super();
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.login = login;
		this.pass = pass;
		this.adminPriviledge = adminPriviledge;
	}

	public Employee(String name, String pass, Long id, int adminPriviledge) {
		this.name = name;
		this.pass = pass;
		this.id = id;
		this.adminPriviledge = adminPriviledge;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAdminPriviledge() {
		return adminPriviledge;
	}
	public void setAdminPriviledge(int adminPriviledge) {
		this.adminPriviledge = adminPriviledge;
	}
}
