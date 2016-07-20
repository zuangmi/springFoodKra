package com.fweb.domain;

public class FoodVO {

	private String food_barcode;
	private String food_image;
	private String food_name;

	private Integer food_calbo;
	private Integer food_protein;
	private Integer food_fat;
	private Integer food_na;
	private Integer food_chol;
	private Integer food_energy;

	public String getFood_barcode() {
		return food_barcode;
	}

	public void setFood_barcode(String food_barcode) {
		this.food_barcode = food_barcode;
	}

	public String getFood_image() {
		return food_image;
	}

	public void setFood_image(String food_image) {
		this.food_image = food_image;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public Integer getFood_calbo() {
		return food_calbo;
	}

	public void setFood_calbo(Integer food_calbo) {
		this.food_calbo = food_calbo;
	}

	public Integer getFood_protein() {
		return food_protein;
	}

	public void setFood_protein(Integer food_protein) {
		this.food_protein = food_protein;
	}

	public Integer getFood_fat() {
		return food_fat;
	}

	public void setFood_fat(Integer food_fat) {
		this.food_fat = food_fat;
	}

	public Integer getFood_na() {
		return food_na;
	}

	public void setFood_na(Integer food_na) {
		this.food_na = food_na;
	}

	public Integer getFood_chol() {
		return food_chol;
	}

	public void setFood_chol(Integer food_chol) {
		this.food_chol = food_chol;
	}

	public Integer getFood_energy() {
		return food_energy;
	}

	public void setFood_energy(Integer food_energy) {
		this.food_energy = food_energy;
	}

	@Override
	public String toString() {
		return "FoodVO [food_barcode=" + food_barcode + ", food_image=" + food_image + ", food_name=" + food_name
				+ ", food_calbo=" + food_calbo + ", food_protein=" + food_protein + ", food_fat=" + food_fat
				+ ", food_na=" + food_na + ", food_chol=" + food_chol + ", food_energy=" + food_energy + "]";
	}

}
