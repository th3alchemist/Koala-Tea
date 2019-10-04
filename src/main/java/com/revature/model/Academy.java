package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="academy")
public class Academy {

	@Id
	@Column(name="academy_id")
	private int academy_id;
	@Column(name="academy_name")
	private String academy_name;
	
//	@OneToMany(fetch=FetchType.EAGER, mappedBy="academy")
//	private List<Movie> movies;
	
	public Academy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Academy(int academy_id, String academy_name) {
		super();
		this.academy_id = academy_id;
		this.academy_name = academy_name;
//		this.movies = movies;
	}

	public int getAcademy_id() {
		return academy_id;
	}
	public void setAcademy_id(int academy_id) {
		this.academy_id = academy_id;
	}
	public String getAcademy_name() {
		return academy_name;
	}
	public void setAcademy_name(String academy_name) {
		this.academy_name = academy_name;
	}
	
//	public List<Movie> getMovies() {
//		return movies;
//	}
//
//	public void setMovies(List<Movie> movies) {
//		this.movies = movies;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + academy_id;
		result = prime * result + ((academy_name == null) ? 0 : academy_name.hashCode());
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
		Academy other = (Academy) obj;
		if (academy_id != other.academy_id)
			return false;
		if (academy_name == null) {
			if (other.academy_name != null)
				return false;
		} else if (!academy_name.equals(other.academy_name))
			return false;
//		if (movies == null) {
//			if (other.movies != null)
//				return false;
//		} else if (!movies.equals(other.movies))
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Academy [academy_id=" + academy_id + ", academy_name=" + academy_name + "]";
	}
}
