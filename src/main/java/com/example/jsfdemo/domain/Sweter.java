package com.example.jsfdemo.domain;

import javax.validation.constraints.Size;

public class Sweter {

	private String name = "unknown";
	private int size = 0;
	private Double price = 0.0; 
	private boolean zip = false;
	
	
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
