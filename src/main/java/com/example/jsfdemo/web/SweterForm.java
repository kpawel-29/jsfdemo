package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Sweter;
import com.example.jsfdemo.service.SweterManager;

@SessionScoped
@Named("sweterF")
public class SweterForm implements Serializable{

	private Sweter sweter = new Sweter();

	@Inject
	private SweterManager sweterManager;
	
	public Sweter getSweter() {
		return sweter;
	}
	public void setSweter(Sweter sweter) {
		this.sweter = sweter;
	}
	
	public ArrayList<Sweter> getAllSweters(){
		return sweterManager.getAllSweters();
	}
	public String addSweterA(){
		sweterManager.addSweter(sweter);
		return "sweterList";
	}
}
