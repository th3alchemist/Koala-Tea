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
    @JoinTable(name="meal_plan_meal_jt",
               joinColumns={@JoinColumn(name="mealid")},
               inverseJoinColumns={@JoinColumn(name="mealplanid")})
    private MealPlan mealPlan;
	

	public Meal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}