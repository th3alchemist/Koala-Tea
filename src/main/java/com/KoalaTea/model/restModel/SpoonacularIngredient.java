package com.KoalaTea.model.restModel;

import java.util.ArrayList;

import com.KoalaTea.model.Unit;

public class SpoonacularIngredient {

	private int id;
	private String original;
	private String originalName;
	private String name;
	private String consistency;
	private ArrayList<String> shoppingListUnits;
	private String aisle;
	private String image;
	private Unit unit;
	
	public SpoonacularIngredient() {
		super();
	}

	public SpoonacularIngredient(int id, String original, String originalName, String name, String consistency,
			ArrayList<String> shoppingListUnits, String aisle, String image, ArrayList<String> meta) {
		super();
		this.id = id;
		this.original = original;
		this.originalName = originalName;
		this.name = name;
		this.consistency = consistency;
		this.shoppingListUnits = shoppingListUnits;
		this.aisle = aisle;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConsistency() {
		return consistency;
	}

	public void setConsistency(String consistency) {
		this.consistency = consistency;
	}

	public ArrayList<String> getShoppingListUnits() {
		return shoppingListUnits;
	}

	public void setShoppingListUnits(ArrayList<String> shoppingListUnits) {
		this.shoppingListUnits = shoppingListUnits;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aisle == null) ? 0 : aisle.hashCode());
		result = prime * result + ((consistency == null) ? 0 : consistency.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((original == null) ? 0 : original.hashCode());
		result = prime * result + ((originalName == null) ? 0 : originalName.hashCode());
		result = prime * result + ((shoppingListUnits == null) ? 0 : shoppingListUnits.hashCode());
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
		SpoonacularIngredient other = (SpoonacularIngredient) obj;
		if (aisle == null) {
			if (other.aisle != null)
				return false;
		} else if (!aisle.equals(other.aisle))
			return false;
		if (consistency == null) {
			if (other.consistency != null)
				return false;
		} else if (!consistency.equals(other.consistency))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		if (originalName == null) {
			if (other.originalName != null)
				return false;
		} else if (!originalName.equals(other.originalName))
			return false;
		if (shoppingListUnits == null) {
			if (other.shoppingListUnits != null)
				return false;
		} else if (!shoppingListUnits.equals(other.shoppingListUnits))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpoonIngredient [id=" + id + ", original=" + original + ", originalName=" + originalName + ", name="
				+ name + ", consistency=" + consistency + ", shoppingListUnits=" + shoppingListUnits + ", aisle="
				+ aisle + ", image=" + image + "]";
	}
}