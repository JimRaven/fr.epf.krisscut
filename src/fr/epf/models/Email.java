package fr.epf.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String subject;
	private String content;
	private Date date;
		
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Email(String subject, String content, Date date) {
		super();
		this.subject = subject;
		this.content = content;
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
