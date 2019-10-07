package com.KoalaTea.model.restModel;

import java.util.ArrayList;

public class SpoonacularRecipe {
    private int id;
    private String image;
    private ArrayList<String> imageUrls;
    private int readyInMinutes;
    private int servings;
    private String title;

    
    
    public SpoonacularRecipe() {
		super();
	}
	public SpoonacularRecipe(int id, String image, ArrayList<String> imageUrls, int readyInMinutes, int servings,
			String title) {
		super();
		this.id = id;
		this.image = image;
		this.imageUrls = imageUrls;
		this.readyInMinutes = readyInMinutes;
		this.servings = servings;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	public int getReadyInMinutes() {
		return readyInMinutes;
	}
	public void setReadyInMinutes(int readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((imageUrls == null) ? 0 : imageUrls.hashCode());
		result = prime * result + readyInMinutes;
		result = prime * result + servings;
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
		SpoonacularRecipe other = (SpoonacularRecipe) obj;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (imageUrls == null) {
			if (other.imageUrls != null)
				return false;
		} else if (!imageUrls.equals(other.imageUrls))
			return false;
		if (readyInMinutes != other.readyInMinutes)
			return false;
		if (servings != other.servings)
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
		return "SpoonaculeRecipe [id=" + id + ", image=" + image + ", imageUrls=" + imageUrls + ", readyInMinutes="
				+ readyInMinutes + ", servings=" + servings + ", title=" + title + "]";
	}
}