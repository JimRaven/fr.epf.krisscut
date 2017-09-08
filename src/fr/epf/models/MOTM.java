package fr.epf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MOTM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int level;
	private String comment;
	private int visible;
		
	public MOTM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MOTM(int level, String comment, int visibility) {
		super();
		this.level = level;
		this.comment = comment;
		this.setVisible(visibility);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}
	
}
