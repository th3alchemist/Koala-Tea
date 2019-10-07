package com.KoalaTea.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="meal")
public class Meal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="course")
	private String course;
	@Column(name="time")
	private Time time;
	
	@ManyToOne // owner side: it doesn't have mappedBy, and can decide how the association is mapped: with a join table
    @JoinTable(name="mealplanmealjt",
               joinColumns={@JoinColumn(name="mealid")},
               inverseJoinColumns={@JoinColumn(name="mealplanid")})
    private MealPlan mealPlan;
	

	public Meal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Meal(int id, String title, String course, Time time, MealPlan mealPlan) {
		super();
		this.id = id;
		this.title = title;
		this.course = course;
		this.time = time;
		this.mealPlan = mealPlan;
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


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}


	public MealPlan getMealPlan() {
		return mealPlan;
	}


	public void setMealPlan(MealPlan mealPlan) {
		this.mealPlan = mealPlan;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + id;
		result = prime * result + ((mealPlan == null) ? 0 : mealPlan.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Meal other = (Meal) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (id != other.id)
			return false;
		if (mealPlan == null) {
			if (other.mealPlan != null)
				return false;
		} else if (!mealPlan.equals(other.mealPlan))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
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
		return "Meal [id=" + id + ", title=" + title + ", course=" + course + ", time=" + time + ", mealPlan="
				+ mealPlan + "]";
	}
	
	
	
	
	
}
