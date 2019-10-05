package com.KoalaTea.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="meal_plan")
public class MealPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="day")
	private Date day;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	@OneToMany(mappedBy = "mealPlan") // inverse side: it has a mappedBy attribute, and can't decide how the association is mapped, since the other side already decided it.
	@Fetch(FetchMode.JOIN)
//	@JsonIgnore
	private List<Meal> meals;
	
	

}
