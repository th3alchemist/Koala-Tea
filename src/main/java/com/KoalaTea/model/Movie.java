package com.KoalaTea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Let's use annotations to map this model instead of using
 * an XML file.
 */

//Denotes that this class is mapped to some entity in the DB
@Entity

//Specifies that this class represents a table with a name of "movie"
@Table(name="movie")
public class Movie {

	//Specifies that this field is a primary key
	@Id
	//Specifies that the primary key is generated for you on the DB
	//side
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//Specifies that this field represents a column in this table with
	//the name of "movie_id"
	@Column(name="movie_id")
	private int movie_id;
	@Column(name="title")
	private String title;
	@ManyToOne(fetch=FetchType.EAGER)
	//This JoinColumn annotation specifies that this property is a 
	//foreign key.
	@JoinColumn(name="genre")
	private Genre genre;
	@ManyToOne
	@JoinColumn(name="academy")
	private Academy academy;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int movie_id, String title, Genre genre, Academy academy) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.genre = genre;
		this.academy = academy;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academy == null) ? 0 : academy.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + movie_id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Movie other = (Movie) obj;
		if (academy == null) {
			if (other.academy != null)
				return false;
		} else if (!academy.equals(other.academy))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (movie_id != other.movie_id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", title=" + title + ", genre=" + genre + ", academy=" + academy + "]";
	}
	
}
