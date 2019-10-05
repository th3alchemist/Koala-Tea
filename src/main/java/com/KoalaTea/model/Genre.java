package com.KoalaTea.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="genre")
public class Genre {

	@Id
	@Column(name="genre_id")
	private int genre_id;
	@Column(name="genre_name")
	private String genre_name;
	/*
	 * In Hibernate, we can map the relationship between two models on
	 * either side of the relationship. In this case, we've decided to
	 * map the relationship on the genre side. The relationship between
	 * a genre and a movie can be expressed as a one to many, so we
	 * use the OneToMany annotation. If we were to create this relationship
	 * on the other side (i.e. the Movie side), we would use the ManyToOne
	 * annotation instead.
	 * 
	 * The fetch type specifies that we should eagerly fetch all of the
	 * associated objects when retrieving our genres. If we were to choose
	 * not to eagerly fetch the associations, we would be using lazy loading
	 * instead. When we lazily load our associations, Hibernate returns
	 * proxies rather than the actual associations. It achieves this by
	 * subclassing our associated class, which is why a Hibernate entity
	 * cannot be a final class.
	 */
//	@OneToMany(fetch=FetchType.EAGER, mappedBy="genre")
//	private List<Movie> movies;
	
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Genre(int genre_id, String genre_name) {
		super();
		this.genre_id = genre_id;
		this.genre_name = genre_name;
//		this.movies = movies;
	}

	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
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
		result = prime * result + genre_id;
		result = prime * result + ((genre_name == null) ? 0 : genre_name.hashCode());
//		result = prime * result + ((movies == null) ? 0 : movies.hashCode());
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
		Genre other = (Genre) obj;
		if (genre_id != other.genre_id)
			return false;
		if (genre_name == null) {
			if (other.genre_name != null)
				return false;
		} else if (!genre_name.equals(other.genre_name))
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
		return "Genre [genre_id=" + genre_id + ", genre_name=" + genre_name + ", movies=" + "]";
	}

}
