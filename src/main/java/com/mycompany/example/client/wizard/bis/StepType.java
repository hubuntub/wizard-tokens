package com.mycompany.example.client.wizard.bis;

public enum StepType {
	DOC_TYPE("red"),
	BO_TYPE("blue"),
	PRIMARY_BO_TYPE("green");
	
	private String color;
	
	private StepType(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
}
