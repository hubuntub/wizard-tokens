package com.mycompany.example.client.wizard.bis;

import com.google.gwt.thirdparty.guava.common.util.concurrent.ServiceManager;

public abstract class Step {

	ServiceManager serviceManager;
	
	public Step(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
		// Dans la méthode qui a besoin d'appeler le service
		// serviceManager.find....
	}

	StepType type;
	
	String value; // selection
	
	String previousValue;

	public StepType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public void setType(StepType type) {
		this.type = type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setPreviousValue(String value) {
		this.previousValue = value;
	}
	
}
