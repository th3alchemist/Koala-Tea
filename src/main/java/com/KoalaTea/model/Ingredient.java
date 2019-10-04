package com.KoalaTea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ingredient")
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="IngredientName")
	private String name;
	@Column(name="MeasurementId")
	private int measurement_id;
	@Column(name="Amount")
	private double amount;
	@Column(name="Spoonacular")
	private boolean spoonacular;
	
	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ingredient(int id, String name, int measurement_id, double amount, boolean spoonacular) {
		super();
		this.id = id;
		this.name = name;
		this.measurement_id = measurement_id;
		this.amount = amount;
		this.spoonacular = spoonacular;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMeasurement_id() {
		return measurement_id;
	}
	public void setMeasurement_id(int measurement_id) {
		this.measurement_id = measurement_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + measurement_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (spoonacular ? 1231 : 1237);
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
		Ingredient other = (Ingredient) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (measurement_id != other.measurement_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (spoonacular != other.spoonacular)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", measurement_id=" + measurement_id + ", amount=" + amount
				+ ", spoonacular=" + spoonacular + "]";
	}
	
	
}
