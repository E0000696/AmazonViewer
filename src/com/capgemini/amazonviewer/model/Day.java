package com.capgemini.amazonviewer.model;

public enum Day {
	SUNDAY ("Domingo"),
	MONDAY("Domingo"), 
	TUESDAY("Domingo"), 
	WEDNESDAY("Domingo"), 
	THURDAY("Domingo"), 
	FRIDAY("Domingo"),
	SATURDAY("Domingo");
	
	private String spanish;
	private Day(String s) {
		spanish = s;
	}
	
	public String getSpanish() {
		return spanish;
	}
	
}
