package com.KoalaTea.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="cookbook")
public class CookBook {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="public")
	private boolean shared;
	@Column(name="userid")
	private int userid;

//	@OneToMany(mappedBy="cookbookid")
//	private List<Recipe> recipes;

	public CookBook() {
		super();
	}

	public CookBook(int id, String title, String description, boolean shared, int user_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.shared = shared;
		this.userid = user_id;
//		this.recipes = recipes;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public int getUser_id() {
		return this.userid;
	}

	public void setUser_id(int user_id) {
		this.userid = user_id;
	}

//	public List<Recipe> getRecipes() {
//		return recipes;
//	}
//
//	public void setRecipes(List<Recipe> recipes) {
//		this.recipes = recipes;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
//		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
		result = prime * result + (shared ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + userid;
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
		CookBook other = (CookBook) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
//		if (recipes == null) {
//			if (other.recipes != null)
//				return false;
//		} else if (!recipes.equals(other.recipes))
//			return false;
		if (shared != other.shared)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CookBook [id=" + id + ", title=" + title + ", description=" + description + ", shared=" + shared
				+ ", user_id=" + userid + "]";
	}
}