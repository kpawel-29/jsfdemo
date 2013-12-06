package com.example.jsfdemo.service;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Sweter;

@ApplicationScoped
public class SweterManager {

	
	private ArrayList<Sweter> db = new ArrayList<Sweter>();
	
	public ArrayList<Sweter> getAllSweters(){
		return db;		
	}
	
	public void addSweter(Sweter sweter){
		Sweter sweter2 = new Sweter();
		sweter2.setName(sweter.getName());
		sweter2.setPrice(sweter.getPrice());
		sweter2.setSize(sweter.getSize());
		sweter2.setZip(sweter.isZip());
		sweter2.setMarka(sweter.getMarka());
		db.add(sweter2);
	}
	//removes sweter with given name
	public void deleteSweter(Sweter sweter){
		Sweter sweterToDelete = null;
		for(Sweter s : db){
			if (s.getName().equals(sweter.getName()))
					sweterToDelete = s;
			break;
		}	
		if (sweterToDelete != null)
			db.remove(sweterToDelete);
	}
	//finds sweter with given name
	public Sweter findSweter(String name){
		Sweter sweter = null;
		for (Sweter s : db){
			if (s.getName().equals(name))
				sweter = s;		
			break;
		}
		return sweter;
	}
	
}
