package com.KoalaTea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="Title")
	private String title;
	@Column(name="Instructions")
	private String instructions;
	@Column(name="Public")
	private boolean shared;
	@Column(name="UserId")
	private int user_id;
	@Column(name="Spoonacular")
	private boolean spoonacular;
	
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recipe(int id, String title, String instructions, boolean shared, int user_id, boolean spoonacular) {
		super();
		this.id = id;
		this.title = title;
		this.instructions = instructions;
		this.shared = shared;
		this.user_id = user_id;
		this.spoonacular = spoonacular;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public boolean isShared() {
		return shared;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public boolean isSpoonacular() {
		return spoonacular;
	}
	public void setSpoonacular(boolean spoonacular) {
		this.spoonacular = spoonacular;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
		result = prime * result + (shared ? 1231 : 1237);
		result = prime * result + (spoonacular ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + user_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (id != other.id)
			return false;
		if (instructions == null) {
			if (other.instructions != null)
				return false;
		} else if (!instructions.equals(other.instructions))
			return false;
		if (shared != other.shared)
			return false;
		if (spoonacular != other.spoonacular)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", instructions=" + instructions + ", shared=" + shared
				+ ", user_id=" + user_id + ", spoonacular=" + spoonacular + "]";
	}
	
	
}
