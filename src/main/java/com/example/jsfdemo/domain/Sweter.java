package com.example.jsfdemo.domain;

import javax.validation.constraints.Size;

public class Sweter {

	private String name = "unknown";
	private int size = 0;
	private Double price = 0.0; 
	private boolean zip = false;
	private String[] marki = {
			"Other","Madicine","Review","Broadway","Guess Wear",
			"Jack & Jones","Marc O'Polo","Solid","Billabong",
			"Lee Cooper", "Guess by Marciano", "Tom Tailor", 
			"Tom Tailor Denim", "Alcott","Levi's"			
	};
	private String marka = "Other";
	
	

	/**
	 * @param name
	 * @param size
	 * @param price
	 * @param zip
	 * @param marki
	 * @param marka
	 */
	public Sweter(String name, int size, Double price, boolean zip,
			String[] marki, String marka) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
		this.zip = zip;
		this.marki = marki;
		this.marka = marka;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String[] getMarki() {
		return marki;
	}
	public void setMarki(String[] marki) {
		this.marki = marki;
	}
	public Sweter(){
		super();
	}
	public Sweter(String name, int size, Double price, boolean zip) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
		this.zip = zip;
	}
	
	@Size(min = 2, max = 20)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean isZip() {
		return zip;
	}
	public void setZip(boolean zip) {
		this.zip = zip;
	}
	
}
